package edu.badpals.ejercicio413.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Joke {

    @Id
    private String id;
    private String icon_url;
    private String url;
    private String value;
    
    public static Joke getJokes() {
        RestTemplate restTemplate = new RestTemplate();
        Joke joke = restTemplate.getForObject("https://api.chucknorris.io/jokes/random", Joke.class);
        return joke;
    }
  





}

