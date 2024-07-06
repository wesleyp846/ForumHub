package com.forum.ForumHub.domain.topico.entity;

import com.forum.ForumHub.domain.topico.dto.DadosNovoTopicoDto;
import com.forum.ForumHub.domain.topico.dto.EditarTopicoDto;
import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;
import com.forum.ForumHub.entity.RespostaEntity;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)
    private List<RespostaEntity> respostas;

    public TopicosEntity(DadosNovoTopicoDto dados, UsuarioEntity usuario) {

        this.titulo = dados.titulo();
        this.mensagem = dados.mensagem();
        this.dataCriacao = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        this.status = EstadoDoTopicoEnum.NAO_REPONDIDA;
        this.usuario = usuario;
        this.curso = dados.curso();
    }

    public void editarTopico(EditarTopicoDto dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }
        if (dados.mensagem() != null) {
            this.mensagem = dados.mensagem();
        }
        if (dados.status() != null) {
            this.status = dados.status();
        }
    }
}
//    public Medico(DadosCadastroMedico dados) {
//        this.ativo = true;
//        this.crm = dados.crm();
//        this.especialidade = dados.especialidade();
//        this.endereco = new Endereco(dados.endereco());
//    }
//
//    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
//        if (dados.email() != null) {
//            this.email = dados.email();
//        }
//        if (dados.endereco() != null) {
//            this.endereco.atualizarInformacoes(dados.endereco());
//        }
//    }
//
//    public void excluir() {
//        this.ativo = false;
//    }
//}