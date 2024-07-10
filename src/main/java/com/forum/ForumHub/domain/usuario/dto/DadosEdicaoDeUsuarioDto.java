package com.forum.ForumHub.domain.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DadosEdicaoDeUsuarioDto(

        String nome,

        @Email(message = "Por padrão deve ser um email")
        String email
) {
}
