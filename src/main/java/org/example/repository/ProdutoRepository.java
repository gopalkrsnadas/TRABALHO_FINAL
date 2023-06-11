package org.example.repository;


import org.example.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("produtoRepository")
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
}
