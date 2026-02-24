package com.wesley.automotivo.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.wesley.automotivo.model.Veiculo;
import com.wesley.automotivo.model.Marca;
import com.wesley.automotivo.repository.VeiculoRepository;
import com.wesley.automotivo.repository.MarcaRepository;

@Service
public class VeiculoService {

    private final VeiculoRepository repository;
    private final MarcaRepository marcaRepository;

    public VeiculoService(VeiculoRepository repository, MarcaRepository marcaRepository) {
        this.repository = repository;
        this.marcaRepository = marcaRepository;
    }

    // Listar todos
    public List<Veiculo> listar() {
        return repository.findAll();
    }

    // Salvar novo veículo
    public Veiculo salvar(Veiculo veiculo) {

        // Buscar marca real no banco
        if (veiculo.getMarca() != null && veiculo.getMarca().getId() != null) {

            Marca marca = marcaRepository.findById(veiculo.getMarca().getId())
                    .orElseThrow(() -> new RuntimeException("Marca não encontrada"));

            veiculo.setMarca(marca);
        }

        return repository.save(veiculo);
    }

    // Buscar por ID
    public Veiculo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado"));
    }

    // Atualizar apenas preço, quilometragem e status
    public Veiculo atualizar(Long id, Veiculo novo) {

        Veiculo existente = buscarPorId(id);

        existente.setPreco(novo.getPreco());
        existente.setQuilometragem(novo.getQuilometragem());
        existente.setStatus(novo.getStatus());

        return repository.save(existente);
    }

    // Remover
    public void remover(Long id) {
        repository.deleteById(id);
    }

    // Filtros

    public List<Veiculo> filtrarPorMarca(String marca) {
        return repository.findByMarca_Nome(marca);
    }

    public List<Veiculo> filtrarPorAno(int ano) {
        return repository.findByAno(ano);
    }

    public List<Veiculo> filtrarPorPreco(double preco) {
        return repository.findByPrecoLessThanEqual(preco);
    }

    public List<Veiculo> filtrarPorStatus(String status) {
        return repository.findByStatus(status);
    }
}
