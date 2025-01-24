package edu.badpals.ejercicio413.controller;

import edu.badpals.ejercicio413.model.entity.Cliente;
import edu.badpals.ejercicio413.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @GetMapping("/clientes")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formulario_cliente";
    }

    @PostMapping("/clientes")
    public String saveCliente(@ModelAttribute Cliente cliente, Model model) {
        ClienteService.guardarCliente(cliente);
        model.addAttribute("cliente", new Cliente());
        return "formulario_cliente";
    }



    @GetMapping("/clientes/all")
    public String mostrarClientes(Model model) {
        model.addAttribute("clientes", clienteService.findAll());
        return "lista_clientes";
    }

}
