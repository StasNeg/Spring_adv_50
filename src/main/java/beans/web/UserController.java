package beans.web;

import beans.daos.UserDAO;
import beans.models.User;
import beans.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    String getUserByEmail(@RequestParam("email") String email, Model model) {
        User current = userService.getUserByEmail(email);
        UserDAO.validateUser(current);
        model.addAttribute("user", current);
        return "userByEmail";
    }

    @RequestMapping(value = "/name", method = RequestMethod.GET)
    ModelAndView getUsersByName(@RequestParam("name") String name) {
        String header = "Get user by name: " + name;
        Map<String, Object> modelUser = new HashMap<>();
        modelUser.put("header", header);
        List<User> users = userService.getUsersByName(name);
        if (users.isEmpty()) throw new RuntimeException("Didn't find any users");
        modelUser.put("user", users);
        return new ModelAndView("PDFUserPage", "modelUser", modelUser);
    }
}
