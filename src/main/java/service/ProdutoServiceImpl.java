package service;

import models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service("alunoService")
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Optional<Produto> getProdutoById(Integer id) {
        return produtoRepository.findById(id);
    }

    @Override
    public List<Produto> getAllProduto() {
        return produtoRepository.findAll();
    }

    @Override
    public void deleteAllProduto() {
        produtoRepository.deleteAll();
    }

    @Override
    public void deleteProdutoById(Integer id) {
        produtoRepository.deleteById(id);
    }

    @Override
    public void updateProduto(Produto produto) {
        if (produto.getId() != null) {
            produtoRepository.save(produto);
        }
    }

    @Override
    public void insertAluno(Produto produto) {
        if (produto.getId() == null) {
            produtoRepository.save(produto);
        }
    }
}

