package com.forum.ForumHub.entity;

import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "resposta")
public class RespostaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "topico_id")
    private TopicosEntity topico;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private UsuarioEntity autor;

    private String solucao;
}