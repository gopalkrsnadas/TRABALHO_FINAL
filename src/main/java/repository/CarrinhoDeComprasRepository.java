package repository;

import models.CarrinhoDeCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.LojaService;

@Repository("CarrinhoDeComprasRepository")
public interface CarrinhoDeComprasRepository extends JpaRepository<CarrinhoDeCompras, Integer> {
}
