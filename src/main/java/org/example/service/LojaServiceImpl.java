package org.example.service;

import org.example.models.Loja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.repository.LojaRepository;

import java.util.List;
import java.util.Optional;

@Service ("lojaService")
public class LojaServiceImpl implements LojaService {

    @Autowired
    LojaRepository lojaRepository;

    @Override
    public Optional<Loja> getLojaById(Integer id) {
        return lojaRepository.findById(id);
    }

    @Override
    public List<Loja> getAllLoja() {
        return lojaRepository.findAll();
    }

    @Override
    public void deleteAllLoja() {
        lojaRepository.deleteAll();
    }

    @Override
    public void deleteLojaById(Integer id) {
        lojaRepository.deleteById(id);
    }

    @Override
    public void updateLoja(Loja loja) {
        if (loja.getId() != null) {
            lojaRepository.save(loja);
        }
    }

    @Override
    public void insertLoja(Loja loja) {
        if (loja.getId() == null) {
            lojaRepository.save(loja);
        }
    }
}
