package com.forum.ForumHub.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosNovoUsuarioDto(

    @NotBlank
    String nome,

    @NotBlank
    @Email
    String email,

    @NotBlank
    @Pattern(regexp = "\\d{6}")
    String senha

//    @NotNull @Valid DadosEndereco endereco) {
//    }

){}
