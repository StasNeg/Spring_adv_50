package beans.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalTime;

@Controller
@RequestMapping(value = "/")
public class RootContoller {
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String handleRequest () {
        return "index";
    }

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public String login () {
        return "login";
    }
}
