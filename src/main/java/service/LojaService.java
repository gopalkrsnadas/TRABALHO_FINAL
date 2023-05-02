package service;

import models.Loja;

import java.util.List;
import java.util.Optional;

public interface LojaService {
    Optional<Loja> getLojaById(Integer id);
    List<Loja> getAllLoja();
    void deleteAllLoja();
    void deleteLojaById(Integer id);
    void updateLoja(Loja loja);
    void insertLoja(Loja loja);
}
