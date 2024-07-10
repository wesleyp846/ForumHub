package com.forum.ForumHub.domain.resposta.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record EditarRespostaDto(

        @NotNull(message = "A mensagem da resposta é obrigatória")
        @Size(min = 10, max = 1000, message = "A mensagem deve ter entre 10 e 1000 caracteres")
        String resposta
) {
    public EditarRespostaDto(String resposta) {

        this.resposta = resposta;
    }
}
