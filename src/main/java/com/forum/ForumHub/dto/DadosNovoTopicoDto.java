package com.forum.ForumHub.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosNovoTopicoDto(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        String curso) { }
