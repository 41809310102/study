package sprintboot628.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/mvc")
public class MvcController {
    @RequestMapping("/index")

    public String getIndex(){
        
        return "/index.html";
    }
}
