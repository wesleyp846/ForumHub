package com.forum.ForumHub.domain.auth;

import jakarta.validation.constraints.NotNull;

public record EnvioAutenticacaoDTO(

        @NotNull(message = "O login é obrigatório")
        String login,

        @NotNull(message = "A senha é obrigatória")
        String senha
) {
}
