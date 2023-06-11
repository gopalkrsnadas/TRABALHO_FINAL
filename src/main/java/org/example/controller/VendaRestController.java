package org.example.controller;

import org.example.models.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.service.VendaService;
import java.util.List;
import java.util.Optional;


@RestController
public class VendaRestController {

    @Autowired
    VendaService vendaService;

    @RequestMapping(value = "/venda", method = RequestMethod.GET)
    public List<Venda> getAllVenda() {
        return vendaService.getAllVenda();
    }

    @RequestMapping(value = "/venda/{id}", method = RequestMethod.GET)
    public Optional<Venda> getAllVenda(@PathVariable Integer id) {
        return vendaService.getVendaById(id);
    }

    @RequestMapping(value = "/venda", method = RequestMethod.POST)
    public void addVenda(@RequestBody Venda venda) {
        vendaService.insertVenda(venda);
    }

    @RequestMapping(value = "/venda", method = RequestMethod.PUT)
    public void updateVenda(@RequestBody Venda venda) {
        vendaService.updateVenda(venda);
    }

    @RequestMapping(value = "/venda/{id}", method = RequestMethod.DELETE)
    public void deleteVenda(@PathVariable Integer id) {
        vendaService.deleteVendaById(id);
    }

    @RequestMapping(value = "/venda", method = RequestMethod.DELETE)
    public void deleteVenda() {
        vendaService.deleteAllVenda();
    }
}