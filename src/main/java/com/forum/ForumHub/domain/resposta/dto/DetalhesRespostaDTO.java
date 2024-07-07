package com.forum.ForumHub.domain.resposta.dto;

import com.forum.ForumHub.domain.resposta.entity.EntityResposta;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;

import java.time.LocalDateTime;

public record DetalhesRespostaDTO(

        Long id,
        LocalDateTime dataCriacao,
        UsuarioEntity usuario,
        TopicosEntity topico,
        String resposta
) {
//    public DetalhesRespostaDTO(DetalhesRespostaDTO dados){
//
//        this(dados.id, dados.dataCriacao, dados.usuario, dados.topico, dados.resposta);
//    }

    public DetalhesRespostaDTO(EntityResposta dados) {

        this(dados.getId(), dados.getDataCriacao(), dados.getUsuario(), dados.getTopico(), dados.getResposta());
    }
}
