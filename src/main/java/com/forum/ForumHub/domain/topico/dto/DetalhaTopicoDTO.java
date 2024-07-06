package com.forum.ForumHub.domain.topico.dto;

import com.forum.ForumHub.domain.topico.entity.CursoEnum;
import com.forum.ForumHub.domain.topico.entity.EstadoDoTopicoEnum;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;

import java.time.LocalDateTime;

public record DetalhaTopicoDTO(

        Long id,
        String usuarioNome,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        CursoEnum curso,
        EstadoDoTopicoEnum status) {

    public DetalhaTopicoDTO(TopicosEntity topico) {
        this(topico.getId(), topico.getUsuario().getNome(), topico.getTitulo(),
                topico.getMensagem(), topico.getDataCriacao(), topico.getCurso(),
                topico.getStatus());
    }
}