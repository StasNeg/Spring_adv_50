package beans.web;

import beans.services.EventService;
import beans.services.UserService;
import beans.web.dto.JsonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static util.MapperUtil.MAPPER;

@Controller
public class UploadController {

    private UserService userService;
    private EventService eventService;

    @Autowired
    public UploadController(UserService userService, EventService eventService) {
        this.userService = userService;
        this.eventService = eventService;
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ModelAndView uploadingPost(@RequestParam("uploadingFile") MultipartFile uploadingFile) throws IOException {
        String content = new String(uploadingFile.getBytes());
        JsonModel jsonModel = MAPPER.readValue(content, JsonModel.class);
        jsonModel.getUsers().forEach(user -> userService.register(user));
        jsonModel.getEvents().forEach(event -> eventService.create(event));
        Map<String, Object> model = new HashMap<>();
        model.put("user", jsonModel.getUsers());
        model.put("event", jsonModel.getEvents());
        return new ModelAndView("uploading", "model", model);
    }
}
