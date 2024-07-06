package com.forum.ForumHub.domain.topico.dto;

import com.forum.ForumHub.domain.topico.entity.CursoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosNovoTopicoDto(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotNull
        CursoEnum curso,

        @NotNull
        Long id_usuario
) { }