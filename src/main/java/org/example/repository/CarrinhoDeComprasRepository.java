package org.example.repository;

import org.example.models.CarrinhoDeCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("carrinhoDeComprasRepository")
public interface CarrinhoDeComprasRepository extends JpaRepository<CarrinhoDeCompras, Integer> {
}
