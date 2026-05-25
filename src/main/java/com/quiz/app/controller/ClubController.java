package com.quiz.app.controller;

import com.quiz.app.model.Club;
import com.quiz.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clubes")
public class ClubController {

    @Autowired private ClubRepository clubRepository;
    @Autowired private EntrenadorRepository entrenadorRepository;
    @Autowired private AsociacionRepository asociacionRepository;
    @Autowired private CompeticionRepository competicionRepository;
    @Autowired private JugadorRepository jugadorRepository;

    // Para la página que muestra la lista y el formulario juntos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clubes", clubRepository.findAll());
        model.addAttribute("club", new Club());  // ← ESTO ES LO QUE FALTA
        model.addAttribute("entrenadores", entrenadorRepository.findAll());
        model.addAttribute("asociaciones", asociacionRepository.findAll());
        model.addAttribute("competiciones", competicionRepository.findAll());
        model.addAttribute("jugadores", jugadorRepository.findAll());
        return "clubes";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Club club) {
        clubRepository.save(club);
        return "redirect:/clubes";
    }
}