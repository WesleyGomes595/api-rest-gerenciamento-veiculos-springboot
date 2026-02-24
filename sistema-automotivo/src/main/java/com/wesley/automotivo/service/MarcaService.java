package com.wesley.automotivo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.wesley.automotivo.model.Marca;
import com.wesley.automotivo.repository.MarcaRepository;

/**
 * Camada de serviço responsável pelas regras de negócio da entidade Marca.
 */
@Service
public class MarcaService {

    private final MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    // Cadastrar nova marca
    public Marca salvar(Marca marca) {
        return repository.save(marca);
    }

    // Listar todas as marcas
    public List<Marca> listar() {
        return repository.findAll();
    }

    // Buscar marca por ID
    public Marca buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));
    }

    // Remover marca
    public void remover(Long id) {
        repository.deleteById(id);
    }
}
