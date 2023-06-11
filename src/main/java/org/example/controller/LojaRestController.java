package org.example.controller;

import org.example.models.Loja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.service.LojaService;

import java.util.List;
import java.util.Optional;


@RestController
public class LojaRestController {

    @Autowired
    LojaService lojaService;

    @RequestMapping(value = "/loja", method = RequestMethod.GET)
    public List<Loja> getAllLoja() {
        return lojaService.getAllLoja();
    }

    @RequestMapping(value = "/loja/{id}", method = RequestMethod.GET)
    public Optional<Loja> getAllLoja(@PathVariable Integer id) {
        return lojaService.getLojaById(id);
    }

    @RequestMapping(value = "/loja", method = RequestMethod.POST)
    public void addLoja(@RequestBody Loja loja) {
        lojaService.insertLoja(loja);
    }

    @RequestMapping(value = "/loja", method = RequestMethod.PUT)
    public void updateLoja(@RequestBody Loja loja) {
        lojaService.updateLoja(loja);
    }

    @RequestMapping(value = "/loja/{id}", method = RequestMethod.DELETE)
    public void deleteLoja(@PathVariable Integer id) {
        lojaService.deleteLojaById(id);
    }

    @RequestMapping(value = "/loja", method = RequestMethod.DELETE)
    public void deleteLoja() {lojaService.deleteAllLoja();}
}