package beans.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HelloContoller {

    @RequestMapping(method = RequestMethod.GET)
    public String hello(ModelMap map){
        map.addAttribute("helloWord","HIIIIIIII");
        return "hello";
    }
}
