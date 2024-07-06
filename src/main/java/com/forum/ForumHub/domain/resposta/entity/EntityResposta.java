package com.forum.ForumHub.domain.resposta.entity;

import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "resposta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EntityResposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resposta_id")
    private Long id;

    private String mensagem;
    private LocalDateTime dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topico_id")
    private TopicosEntity topico;
}
