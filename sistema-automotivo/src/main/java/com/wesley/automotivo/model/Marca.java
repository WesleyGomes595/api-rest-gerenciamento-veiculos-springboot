package com.wesley.automotivo.model;

import jakarta.persistence.*;

/**
 * Entidade que representa a marca do veículo.
 * Responsável por armazenar apenas as informações da marca.
 */
@Entity
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    public Marca() {
    }

    public Marca(String nome) {
        this.nome = nome;
    }

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
