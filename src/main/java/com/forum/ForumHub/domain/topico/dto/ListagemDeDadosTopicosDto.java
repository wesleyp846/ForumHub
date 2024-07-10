package com.forum.ForumHub.domain.topico.dto;

import com.forum.ForumHub.domain.topico.entity.EstadoDoTopicoEnum;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import com.forum.ForumHub.domain.usuario.dto.UsuarioSimplesDTO;

import java.time.LocalDateTime;

public record ListagemDeDadosTopicosDto(

        Long id,
        String titulo,
        String mensagem,
        LocalDateTime dataCriacao,
        EstadoDoTopicoEnum status,
        UsuarioSimplesDTO autor
){
    public ListagemDeDadosTopicosDto(TopicosEntity topico){

        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                new UsuarioSimplesDTO(String.valueOf(
                        topico.getUsuario()
                        .getNome())));
    }
}