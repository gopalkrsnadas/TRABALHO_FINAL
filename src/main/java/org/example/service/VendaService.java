package org.example.service;


import org.example.models.Venda;

import java.util.List;
import java.util.Optional;

public interface VendaService {

    Optional<Venda> getVendaById(Integer id);
    List<Venda> getAllVenda();
    void deleteAllVenda();
    void deleteVendaById(Integer id);
    void updateVenda(Venda venda);
    void insertVenda(Venda venda);
}
