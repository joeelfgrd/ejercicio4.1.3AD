package edu.badpals.ejercicio413.controller;

import edu.badpals.ejercicio413.model.entity.Cliente;
import edu.badpals.ejercicio413.model.entity.Joke;
import edu.badpals.ejercicio413.model.entity.Quote;
import edu.badpals.ejercicio413.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class JokeController {
    @GetMapping("/jokes")
    public String showJokes(Model model) {
        model.addAttribute("jokes", Joke.getJokes());
        return "jokes";
    }



}