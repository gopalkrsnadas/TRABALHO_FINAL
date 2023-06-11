package org.example.controller;

import org.example.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.service.ClienteService;

import java.util.List;
import java.util.Optional;


//@RestController = Define uma classe que contém métodos para uma API RESTful
@RestController
public class ClienteRestController {

    @Autowired
    ClienteService clienteService;

    //@RequestMapping = Mapeia requisições REST

    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public List<Cliente> getAllCliente() {
        return clienteService.getAllCliente();
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.GET)
    public Optional<Cliente> getAllCliente(@PathVariable Integer id) {
        return clienteService.getClienteById(id);
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public void addCliente(@RequestBody Cliente cliente) {
        clienteService.insertCliente(cliente);
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.PUT)
    public void updateCliente(@RequestBody Cliente cliente) {
        clienteService.updateCliente(cliente);
    }

    @RequestMapping(value = "/cliente/{id}", method = RequestMethod.DELETE)
    public void deleteCliente(@PathVariable Integer id) {
        clienteService.deleteClienteById(id);
    }

    @RequestMapping(value = "/cliente", method = RequestMethod.DELETE)
    public void deleteCliente() {
        clienteService.deleteAllCliente();
    }
}
