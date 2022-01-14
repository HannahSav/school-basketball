package com.example.spring_jpa_gradle.controller;

import com.example.spring_jpa_gradle.data.Tournament;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminBean {
    /*@GetMapping("/admin")
    public String getAdminLoginPage() {
        return "admin.html";
    }*/

    @GetMapping("/create_tournament")
    public String greetingForm(Model model) {
        model.addAttribute("tournament", new Tournament());
        return "tournament";
    }

    @PostMapping("/create_tournament")
    public String createTournament(@ModelAttribute Tournament tournament, Model model) {
        model.addAttribute("tournament", tournament);
        return "result";
    }

}
