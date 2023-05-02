package service;

import models.CarrinhoDeCompras;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CarrinhoDeComprasRepository;

import java.util.List;
import java.util.Optional;

@Service ("CarrinhoDeComprasService")
public class CarrinhoDeComprasServiceImpl implements CarrinhoDeComprasService{

    @Autowired
    CarrinhoDeComprasRepository carrinhoDeComprasRepository;

    @Override
    public Optional<CarrinhoDeCompras> getCarrinhoDeComprasById(Integer id) { return carrinhoDeComprasRepository.findById(id);}

    @Override
    public List<CarrinhoDeCompras> getAllCarrinhoDeCompras() {
        return carrinhoDeComprasRepository.findAll();
    }

    @Override
    public void deleteAllCarrinhoDeCompras() {
        carrinhoDeComprasRepository.deleteAll();
    }

    @Override
    public void deleteCarrinhoDeComprasById(Integer id) {
        carrinhoDeComprasRepository.deleteById(id);
    }

    @Override
    public void updateCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras) {
        if (carrinhoDeCompras.getId() != null) {
            carrinhoDeComprasRepository.save(carrinhoDeCompras);
        }
    }

    @Override
    public void insertCarrinhoDeCompras(CarrinhoDeCompras carrinhoDeCompras) {
        if (carrinhoDeCompras.getId() == null) {
            carrinhoDeComprasRepository.save(carrinhoDeCompras);
        }
    }
}




