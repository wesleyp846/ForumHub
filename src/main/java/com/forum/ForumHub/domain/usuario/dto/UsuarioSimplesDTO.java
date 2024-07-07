package com.forum.ForumHub.domain.usuario.dto;

import com.forum.ForumHub.domain.resposta.entity.EntityResposta;

public record UsuarioSimplesDTO(

        String nomeUsuario) {

    public UsuarioSimplesDTO(EntityResposta usuarioResposta){

        this(usuarioResposta.getUsuario().getNome());
    }
}