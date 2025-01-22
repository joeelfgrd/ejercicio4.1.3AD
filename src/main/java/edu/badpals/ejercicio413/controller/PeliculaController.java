package edu.badpals.ejercicio413.controller;

import edu.badpals.ejercicio413.model.entity.Pelicula;
import edu.badpals.ejercicio413.model.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeliculaController {
    @Autowired
    private PeliculaRepository peliculaRepository;

    @GetMapping("/peliculas")
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaRepository.findAll());
        return "peliculas";
    }

    @PostMapping("/peliculas/votar/{id}")
    public String votarPelicula(@PathVariable Long id) {
        Pelicula pelicula = peliculaRepository.findById(id).orElse(null);
        if (pelicula != null) {
            pelicula.setVotos(pelicula.getVotos() + 1);
            peliculaRepository.save(pelicula);
        }
        return "redirect:/peliculas";
    }

}
