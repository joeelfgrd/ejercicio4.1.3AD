package edu.badpals.ejercicio413.service;

import edu.badpals.ejercicio413.model.entity.Cliente;
import edu.badpals.ejercicio413.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private static ClienteRepository clienteRepository;


    public static void guardarCliente(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public Object findAll() {
        return clienteRepository.findAll();
    }
}
