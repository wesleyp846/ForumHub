package com.forum.ForumHub.dto;

import java.time.LocalDateTime;

public record ListagemDeTodosOsTopicosDto(Long id, String titulo, String mensagem, LocalDateTime dataCriacao) {

   // this(topicos.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
}
