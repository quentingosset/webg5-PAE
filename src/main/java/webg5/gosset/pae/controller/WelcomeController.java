package webg5.gosset.pae.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * WelcomeController
 */
@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String greeting( @RequestParam(defaultValue = "Quentin") String name, Model model){
        model.addAttribute("name", name);
        return "welcome";
    }
}