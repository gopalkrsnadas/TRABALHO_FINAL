package repository;

import models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("produtoRepository")
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
}
