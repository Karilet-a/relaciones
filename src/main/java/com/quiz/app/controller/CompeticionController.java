package com.quiz.app.controller;

import com.quiz.app.model.Competicion;
import com.quiz.app.repository.CompeticionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/competiciones")
public class CompeticionController {

    @Autowired
    private CompeticionRepository competicionRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("competiciones", competicionRepository.findAll());
        model.addAttribute("competicion", new Competicion());
        return "competiciones";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Competicion competicion) {
        competicionRepository.save(competicion);
        return "redirect:/competiciones";
    }
}