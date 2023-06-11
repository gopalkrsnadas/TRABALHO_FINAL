package org.example.service;

import org.example.models.Venda;
import org.example.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("vendaService")
public class VendaServiceImpl implements VendaService {

    @Autowired
    VendaRepository vendaRepository;

    @Override
    public Optional<Venda> getVendaById(Integer id) {
        return vendaRepository.findById(id);
    }

    @Override
    public List<Venda> getAllVenda() {
        return vendaRepository.findAll();
    }

    @Override
    public void deleteAllVenda() {
        vendaRepository.deleteAll();
    }

    @Override
    public void deleteVendaById(Integer id) {
        vendaRepository.deleteById(id);
    }

    @Override
    public void updateVenda(Venda venda) {
        if (venda.getId() != null) {
            vendaRepository.save(venda);
        }
    }

    @Override
    public void insertVenda(Venda venda) {
        if (venda.getId() == null) {
            vendaRepository.save(venda);
        }
    }
}