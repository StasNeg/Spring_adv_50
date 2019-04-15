package beans.web.rest;

import beans.models.User;
import beans.services.UserService;
import beans.web.dto.UserTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/rest/user")
public class UserRestController {
    private final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserTo createUser(@RequestBody UserTo user){
        return new UserTo(userService.register(UserTo.fromTo(user)));
    }
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public UserTo deleteUser(@PathVariable String id){
        User delete = userService.getById(Long.parseLong(id));
        userService.remove(delete);
        return new UserTo(delete);
    }

    @ResponseBody
    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public UserTo getUserByEmail(@RequestParam(value="email") String email){
        System.out.println("email:" + email);
        return new UserTo(userService.getUserByEmail(email));
    }

    @ResponseBody
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<UserTo> getUsersByName(@PathVariable String name){
        return userService.getUsersByName(name).stream().map(UserTo::new).collect(Collectors.toList());
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<UserTo> getAll(){
        return userService.getAll().stream().map(UserTo::new).collect(Collectors.toList());
    }
}
