package com.forum.ForumHub.domain.topico.dto;

import com.forum.ForumHub.domain.topico.entity.EstadoDoTopicoEnum;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;

import java.time.LocalDateTime;

public record ListagemDeDadosTopicosDto(

        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        EstadoDoTopicoEnum status
){
    public ListagemDeDadosTopicosDto(TopicosEntity topico){

        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus());
    }
}
