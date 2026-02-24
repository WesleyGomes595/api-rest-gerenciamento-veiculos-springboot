package com.wesley.automotivo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.wesley.automotivo.model.Veiculo;
import com.wesley.automotivo.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Veiculo> listar() {
        return service.listar();
    }

    @PostMapping
    public Veiculo criar(@RequestBody Veiculo veiculo) {
        return service.salvar(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculo atualizar(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        return service.atualizar(id, veiculo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.remover(id);
    }

    @GetMapping("/marca/{marca}")
    public List<Veiculo> porMarca(@PathVariable String marca) {
        return service.filtrarPorMarca(marca);
    }

    @GetMapping("/ano/{ano}")
    public List<Veiculo> porAno(@PathVariable int ano) {
        return service.filtrarPorAno(ano);
    }

    @GetMapping("/preco")
    public List<Veiculo> porPreco(@RequestParam double max) {
        return service.filtrarPorPreco(max);
    }

    @GetMapping("/status/{status}")
    public List<Veiculo> porStatus(@PathVariable String status) {
        return service.filtrarPorStatus(status);
    }
}
