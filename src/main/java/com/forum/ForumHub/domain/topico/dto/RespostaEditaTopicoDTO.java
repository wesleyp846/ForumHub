package com.forum.ForumHub.domain.topico.dto;

import com.forum.ForumHub.domain.topico.entity.EstadoDoTopicoEnum;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;

public record RespostaEditaTopicoDTO(

        String titulo,
        String mensagem,
        EstadoDoTopicoEnum status) {

    public RespostaEditaTopicoDTO(TopicosEntity topico) {
        this(topico.getTitulo(), topico.getMensagem(), topico.getStatus());
    }
}
