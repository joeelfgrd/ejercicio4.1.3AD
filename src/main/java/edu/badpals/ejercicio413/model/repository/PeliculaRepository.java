package edu.badpals.ejercicio413.model.repository;

import edu.badpals.ejercicio413.model.entity.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {
    Pelicula findByTitulo(String titulo);
    Pelicula findById(long id);
}
