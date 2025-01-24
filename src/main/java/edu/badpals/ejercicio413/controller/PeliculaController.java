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
            if (pelicula.getVotos() >= 10) {
                pelicula.setImagenUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQs-bxyUShUcDwTYQzl1z_KY0zxRhNuiQoBEizjh9cJgXJgxM3GRr-h5bErV8wrAUtCTmw&usqp=CAU");
            }
            if(pelicula.getVotos() >= 20){
                pelicula.setImagenUrl("https://upload.wikimedia.org/wikipedia/commons/b/bf/Clown_chili_peppers.jpg");
            }
            if(pelicula.getVotos() >= 30){
                pelicula.setImagenUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRHuClBV4e6pBdktJPwCIa3u56AdGg_P1uHZw&s");
            }
            if(pelicula.getVotos() >= 40){
                pelicula.setImagenUrl("https://www.plasticosur.com/images/thumbs/0065338_carn6274-nariz-payaso-grande-7cm-foam-6274.jpeg");
            }
            peliculaRepository.save(pelicula);
        }
        return "redirect:/peliculas";
    }

}
