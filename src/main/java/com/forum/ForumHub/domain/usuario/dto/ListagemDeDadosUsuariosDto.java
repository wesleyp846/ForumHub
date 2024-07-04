package com.forum.ForumHub.domain.usuario.dto;

import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;
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