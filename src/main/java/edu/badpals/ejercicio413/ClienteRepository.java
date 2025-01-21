package edu.badpals.ejercicio413;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Cliente findById(long id);
    Cliente findByNombre(String nombre);
    List<Cliente> findByApellido(String apellido);
    Cliente findByDireccion(String direccion);
    Cliente findByTelefono(String telefono);
}
