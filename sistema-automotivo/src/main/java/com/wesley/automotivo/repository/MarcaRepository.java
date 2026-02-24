package com.wesley.automotivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wesley.automotivo.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
