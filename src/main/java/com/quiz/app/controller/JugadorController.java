package com.quiz.app.controller;

import com.quiz.app.model.Jugador;
import com.quiz.app.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorRepository jugadorRepository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("jugadores", jugadorRepository.findAll());
        model.addAttribute("jugador", new Jugador());
        return "jugadores";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Jugador jugador) {
        jugadorRepository.save(jugador);
        return "redirect:/jugadores";
    }
}