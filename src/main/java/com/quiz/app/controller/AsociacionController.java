package com.quiz.app.controller;

import com.quiz.app.model.Asociacion;
import com.quiz.app.repository.AsociacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/asociaciones")
public class AsociacionController {

    @Autowired
    private AsociacionRepository asociacionRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        model.addAttribute("asociacion", new Asociacion());
        return "asociaciones";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Asociacion asociacion) {
        asociacionRepository.save(asociacion);
        return "redirect:/asociaciones";
    }
}