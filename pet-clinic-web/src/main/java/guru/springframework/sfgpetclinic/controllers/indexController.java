package guru.springframework.sfgpetclinic.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping({"", "/", "index", "index.html"})
    public String index(){
        return "index";
    }

    @RequestMapping("/oups")
    public String oupsHandler(){

        return "notimplemented";
    }
}
