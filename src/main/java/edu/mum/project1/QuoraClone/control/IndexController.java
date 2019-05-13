package edu.mum.project1.QuoraClone.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){

        return "login";
    }


    @RequestMapping("/team")
    public String team(){
        return "team";
    }
}
