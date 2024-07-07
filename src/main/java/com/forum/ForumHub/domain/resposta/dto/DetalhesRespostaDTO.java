package com.forum.ForumHub.domain.resposta.dto;

import com.forum.ForumHub.domain.resposta.entity.EntityResposta;
import com.forum.ForumHub.domain.usuario.dto.UsuarioSimplesDTO;

import java.time.LocalDateTime;

public record DetalhesRespostaDTO(

        Long id,
        LocalDateTime dataCriacao,
        String usuario,
        String topico,
        String resposta,
        UsuarioSimplesDTO usuarioRespondeu
) {
    public DetalhesRespostaDTO(EntityResposta dados) {

        this(dados.getId(),
                dados.getDataCriacao(),
                dados.getUsuario().getNome(),
                dados.getTopico().getMensagem(),
                dados.getResposta(),
                new UsuarioSimplesDTO(dados));
    }
}
