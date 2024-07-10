package com.forum.ForumHub.domain.topico.dto;

import com.forum.ForumHub.domain.topico.entity.CursoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosNovoTopicoDto(

        @NotBlank(message = "O título não pode ser nulo")
        String titulo,

        @NotBlank(message = "A mensagem não pode ser nula")
        String mensagem,

        @NotNull(message = "o Curso não pode ser nulo")
        CursoEnum curso,

        @NotNull(message = "É obrigatória a escolha de um id de Usuário")
        Long id_usuario
) { }