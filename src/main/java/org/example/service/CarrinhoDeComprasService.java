package org.example.service;


import org.example.models.CarrinhoDeCompras;
import java.util.List;
import java.util.Optional;

public interface CarrinhoDeComprasService {
    Optional<CarrinhoDeCompras> getCarrinhoDeComprasById(Integer id);
    List<CarrinhoDeCompras> getAllCarrinhoDeCompras();
    void deleteAllCarrinhoDeCompras();
    void deleteCarrinhoDeComprasById(Integer id);
    void updateCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras);
    void insertCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras);
}
