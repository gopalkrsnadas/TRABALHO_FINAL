package org.example.repository;

import org.example.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository ("vendaRepository")
public interface VendaRepository extends JpaRepository<Venda, Integer>{
}
