package com.wesley.automotivo.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.wesley.automotivo.model.Marca;
import com.wesley.automotivo.service.MarcaService;

/*
 * Controller responsável por expor
 * os endpoints REST da entidade Marca.
 */

@RestController
@RequestMapping("/marcas")
public class MarcaController {

    private final MarcaService service;

    public MarcaController(MarcaService service) {
        this.service = service;
    }

    @PostMapping
    public Marca criar(@RequestBody Marca marca) {
        return service.salvar(marca);
    }

    @GetMapping
    public List<Marca> listar() {
        return service.listar();
    }
}
