package com.forum.ForumHub.domain.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosEdicaoDeUsuarioDto(

        @NotNull
        Long id,

        String nome,

        @Email
        String email
) {
}
