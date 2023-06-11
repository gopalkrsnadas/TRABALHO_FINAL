package org.example.controller;

import org.example.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.example.service.ProdutoService;

import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoRestController {

    @Autowired
    ProdutoService produtoService;

    @RequestMapping(value = "/produto", method = RequestMethod.GET)
    public List<Produto> getAllProduto() {
        return produtoService.getAllProduto();
    }

    @RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
    public Optional<Produto> getAllProduto(@PathVariable Integer id) {
        return produtoService.getProdutoById(id);
    }

    @RequestMapping(value = "/produto", method = RequestMethod.POST)
    public void addProduto(@RequestBody Produto produto) {
        produtoService.insertProduto(produto);
    }

    @RequestMapping(value = "/produto", method = RequestMethod.PUT)
    public void updateProduto(@RequestBody Produto produto) {
        produtoService.updateProduto(produto);
    }

    @RequestMapping(value = "/produto/{id}", method = RequestMethod.DELETE)
    public void deleteProduto(@PathVariable Integer id) {
        produtoService.deleteProdutoById(id);
    }

    @RequestMapping(value = "/produto", method = RequestMethod.DELETE)
    public void deleteProduto() {
        produtoService.deleteAllProduto();
    }
}
