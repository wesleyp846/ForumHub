package com.forum.ForumHub.domain.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosNovoUsuarioDto(

    @NotBlank(message = "O nome não pode ser nulo")
    String nome,

    @NotBlank(message = "o email não pode ser nulo")
    @Email
    String email,

    @NotBlank(message = "A senha não pode ser nula e deve ter 6 digitos")
    @Pattern(regexp = "\\d{6}")
    String senha
){}