package com.forum.ForumHub.domain.resposta.dto;

public record EditarRespostaDto(

        String resposta
) {
    public EditarRespostaDto(String resposta) {
        this.resposta = resposta;
    }
}
