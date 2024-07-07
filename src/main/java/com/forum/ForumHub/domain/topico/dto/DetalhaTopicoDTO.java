package com.forum.ForumHub.domain.topico.dto;

import com.forum.ForumHub.domain.resposta.dto.RespostaDTO;
import com.forum.ForumHub.domain.topico.entity.CursoEnum;
import com.forum.ForumHub.domain.topico.entity.EstadoDoTopicoEnum;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;

import java.time.LocalDateTime;
import java.util.List;

public record DetalhaTopicoDTO(

    String titulo,
    String mensagem,
    LocalDateTime dataCriacao,
    EstadoDoTopicoEnum status,
    String autor,
    CursoEnum curso,

    List<RespostaDTO> respostas) {

    public DetalhaTopicoDTO(TopicosEntity topico, String usuarioNome, List<RespostaDTO> respostas) {

        this(topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                usuarioNome,
                topico.getCurso(),
                respostas);
    }
}