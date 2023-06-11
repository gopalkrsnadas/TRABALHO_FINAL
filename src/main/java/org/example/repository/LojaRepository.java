package org.example.repository;

import org.example.models.Loja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("lojaRepository")
public interface LojaRepository extends JpaRepository<Loja, Integer> {
}
