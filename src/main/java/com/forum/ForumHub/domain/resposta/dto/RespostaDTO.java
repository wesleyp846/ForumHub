package com.forum.ForumHub.domain.resposta.dto;

import com.forum.ForumHub.domain.resposta.entity.EntityResposta;

public record RespostaDTO(

        String resposta,
        String autorNome) {

    public RespostaDTO(EntityResposta resposta) {
        this(resposta.getResposta(), resposta.getUsuario().getNome());
    }
}