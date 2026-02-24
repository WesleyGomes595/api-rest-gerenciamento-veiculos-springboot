package com.wesley.automotivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wesley.automotivo.model.Veiculo;

import java.util.List;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    List<Veiculo> findByMarca_Nome(String nome);

    List<Veiculo> findByAno(int ano);

    List<Veiculo> findByPrecoLessThanEqual(double preco);

    List<Veiculo> findByStatus(String status);
}
