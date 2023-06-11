package org.example.service;

import org.example.models.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    Optional<Produto> getProdutoById(Integer id);
    List<Produto> getAllProduto();
    void deleteAllProduto();
    void deleteProdutoById(Integer id);
    void updateProduto(Produto produto);
    void insertProduto(Produto produto);
}
