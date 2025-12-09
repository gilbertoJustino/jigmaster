package com.jigmaster.repository;

import com.jigmaster.model.Jig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JigRepository extends JpaRepository<Jig, Long> {
    // Buscar apenas ativos
    List<Jig> findByAtivoTrue();

    // Buscar por ID apenas se ativo
    Optional<Jig> findByIdAndAtivoTrue(Long id);

    // Buscar por modelo (ativos)
    List<Jig> findByModeloContainingIgnoreCaseAndAtivoTrue(String modelo);
}
