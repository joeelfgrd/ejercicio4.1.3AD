package edu.badpals.ejercicio413;

import edu.badpals.ejercicio413.model.entity.Pelicula;
import edu.badpals.ejercicio413.model.repository.ClienteRepository;
import edu.badpals.ejercicio413.model.repository.CustomerRepository;
import edu.badpals.ejercicio413.model.entity.Customer;
import edu.badpals.ejercicio413.model.repository.PeliculaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingDataJpaApplication {

  private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(AccessingDataJpaApplication.class);
  }

  @Bean
  public CommandLineRunner demoCustomer(CustomerRepository repository) {
    return (args) -> {
      // save a few customers
      repository.save(new Customer("Jack", "Bauer"));
      repository.save(new Customer("Chloe", "O'Brian"));
      repository.save(new Customer("Kim", "Bauer"));
      repository.save(new Customer("David", "Palmer"));
      repository.save(new Customer("Michelle", "Dessler"));

      // fetch all customers
      log.info("Customers found with findAll():");
      log.info("-------------------------------");
      repository.findAll().forEach(customer -> {
        log.info(customer.toString());
      });
      log.info("");

      // fetch an individual customer by ID
      Customer customer = repository.findById(1L);
      log.info("Customer found with findById(1L):");
      log.info("--------------------------------");
      log.info(customer.toString());
      log.info("");

      // fetch customers by last name
      log.info("Customer found with findByLastName('Bauer'):");
      log.info("--------------------------------------------");
      repository.findByLastName("Bauer").forEach(bauer -> {
        log.info(bauer.toString());
      });
      log.info("");
    };
  }

  @Bean
  public CommandLineRunner demoPelicula(PeliculaRepository peliculas) {
    return (args) -> {
      peliculas.save(new Pelicula("Avatar", "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-Qzx9P3SPQhxUCGOuXLMbiIB7GleKqi.png", 0));
      peliculas.save(new Pelicula("The Shawshank Redemption", "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-Qzx9P3SPQhxUCGOuXLMbiIB7GleKqi.png", 0));
      peliculas.save(new Pelicula("Pulp Fiction", "https://hebbkx1anhila5yf.public.blob.vercel-storage.com/image-Qzx9P3SPQhxUCGOuXLMbiIB7GleKqi.png", 0));
      peliculas.save(new Pelicula("Pulp Fiction", "https://i.blogs.es/8ef1df/joker-joaquin-phoenix/1366_2000.jpg", 0));


      log.info("Peliculas found with findAll():");
      log.info("-------------------------------");
      peliculas.findAll().forEach(pelicula -> {
        log.info(pelicula.toString());
      });
      log.info("");

      Pelicula pelicula = peliculas.findById(1L);
      log.info("Pelicula found with findById(1L):");
      log.info("--------------------------------");
      log.info(pelicula.toString());
      log.info("");

    };
  }
}