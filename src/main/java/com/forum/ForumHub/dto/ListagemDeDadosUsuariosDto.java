package com.forum.ForumHub.dto;

import com.forum.ForumHub.entity.UsuarioEntity;

public record ListagemDeDadosUsuariosDto(

        Long id,
        String nome,
        String email
) {
    public ListagemDeDadosUsuariosDto(UsuarioEntity usuario){

        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}