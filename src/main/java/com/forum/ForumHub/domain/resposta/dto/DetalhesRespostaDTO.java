package com.forum.ForumHub.domain.resposta.dto;

import com.forum.ForumHub.domain.resposta.entity.EntityResposta;

import java.time.LocalDateTime;

public record DetalhesRespostaDTO(

        Long id,
        LocalDateTime dataCriacao,
        String usuario,
        String topico,
        String resposta
) {
//    public DetalhesRespostaDTO(DetalhesRespostaDTO dados){
//
//        this(dados.id, dados.dataCriacao, dados.usuario, dados.topico, dados.resposta);
//    }

    public DetalhesRespostaDTO(EntityResposta dados) {

        this(dados.getId(),
                dados.getDataCriacao(),
                dados.getUsuario().getNome(),
                dados.getTopico().getMensagem(),
                dados.getResposta());
    }
}
