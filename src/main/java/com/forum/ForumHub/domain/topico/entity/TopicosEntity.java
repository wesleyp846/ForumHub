package com.forum.ForumHub.domain.topico.entity;

import com.forum.ForumHub.domain.resposta.entity.EntityResposta;
import com.forum.ForumHub.domain.topico.dto.EditarTopicoDto;
import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Table(name = "topicos")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class TopicosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING)
    private EstadoDoTopicoEnum status;

    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario")
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
    private List<EntityResposta> respostas;

    public TopicosEntity(String titulo, String mensagem, CursoEnum curso, UsuarioEntity usuario) {

        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataCriacao = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.status = EstadoDoTopicoEnum.NAO_REPONDIDA;
        this.curso = curso;
        this.usuario = usuario;
        }


    public void editarTopico(EditarTopicoDto dados) {
        if (dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null){
            this.mensagem = dados.mensagem();
        }
        if (dados.status() != null){
            this.status = dados.status();
        }
    }
}