package com.forum.ForumHub.domain.resposta.entity;

import com.forum.ForumHub.domain.resposta.dto.DtoDadosNovaResposta;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@Table(name = "resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EntityResposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resposta;
    private LocalDateTime dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private TopicosEntity topico;


    public EntityResposta(TopicosEntity topico, UsuarioEntity usuario, DtoDadosNovaResposta dados) {

        this.topico = topico;
        this.usuario = usuario;
        this.resposta = dados.resposta();
        this.dataCriacao = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }
}
