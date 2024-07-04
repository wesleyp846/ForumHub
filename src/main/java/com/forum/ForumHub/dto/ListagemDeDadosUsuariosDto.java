package com.forum.ForumHub.dto;

import com.forum.ForumHub.entity.UsuarioEntity;
import jakarta.validation.constraints.Email;

public record ListagemDeDadosUsuariosDto(

        Long id,
        String nome,

        @Email
        String email
) {
    public ListagemDeDadosUsuariosDto(UsuarioEntity usuario){

        this(usuario.getId(), usuario.getNome(), usuario.getEmail());
    }
}