package com.forum.ForumHub.domain.topico.dto;

import com.forum.ForumHub.domain.topico.entity.EstadoDoTopicoEnum;

public record EditarTopicoDto(

        String titulo,
        String mensagem,
        EstadoDoTopicoEnum status) {}