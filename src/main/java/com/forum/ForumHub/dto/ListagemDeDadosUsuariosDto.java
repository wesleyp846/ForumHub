package com.forum.ForumHub.dto;

import com.forum.ForumHub.entity.UsuarioEntity;

public record ListagemDeDadosUsuariosDto(

        String nome,
        String email
) {
    public ListagemDeDadosUsuariosDto(UsuarioEntity usuario){

        this(usuario.getNome(), usuario.getEmail());
    }
}