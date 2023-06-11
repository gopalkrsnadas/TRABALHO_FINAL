package org.example.controller;

import org.example.models.CarrinhoDeCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.service.CarrinhoDeComprasService;

import java.util.List;
import java.util.Optional;

@RestController
public class CarrinhoDeComprasRestController {

    @Autowired
    CarrinhoDeComprasService carrinhoDeComprasService;

    @RequestMapping(value = "/carrinhoDeCompras", method = RequestMethod.GET)
    public List<CarrinhoDeCompras> getAllCarrinhoDeCompras() {return carrinhoDeComprasService.getAllCarrinhoDeCompras();}

    @RequestMapping(value = "/carrinhoDeCompras/{id}", method = RequestMethod.GET)
    public Optional<CarrinhoDeCompras> getAllCarrinhoDeCompras(@PathVariable Integer id) {return carrinhoDeComprasService.getCarrinhoDeComprasById(id);}

    @RequestMapping(value = "/carrinhoDeCompras", method = RequestMethod.POST)
    public void addCarrinhoDeCompras(@RequestBody CarrinhoDeCompras carrinhoDeCompras) {carrinhoDeComprasService.insertCarrinhoDeCompras(carrinhoDeCompras);}

    @RequestMapping(value = "/carrinhoDeCompras", method = RequestMethod.PUT)
    public void updateCarrinhoDeCompras(@RequestBody CarrinhoDeCompras carrinhoDeCompras) {carrinhoDeComprasService.updateCarrinhoDeCompras(carrinhoDeCompras);}

    @RequestMapping(value = "/carrinhoDeCompras/{id}", method = RequestMethod.DELETE)
    public void deleteCarrinhoDeCompras(@PathVariable Integer id) {carrinhoDeComprasService.deleteCarrinhoDeComprasById(id);}

    @RequestMapping(value = "/carrinhoDeCompras", method = RequestMethod.DELETE)
    public void deleteCarrinhoDeCompras() {
        carrinhoDeComprasService.deleteAllCarrinhoDeCompras();
    }
}
