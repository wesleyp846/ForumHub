package com.forum.ForumHub.entity;

import com.forum.ForumHub.dto.DadosNovoTopicoDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "curso")
public class CursoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String categoria;

    public CursoEntity(DadosNovoTopicoDto dados) {
        this.nome = dados.curso();
    }
}