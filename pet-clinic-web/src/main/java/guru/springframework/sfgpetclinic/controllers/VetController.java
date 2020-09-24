package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping({"/Vets", "/Vets/index", "/Vets/index.html"})
    public String listVets(){

        return "Vets/index";
    }
}
