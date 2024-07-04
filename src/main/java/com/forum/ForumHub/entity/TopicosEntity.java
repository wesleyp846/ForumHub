package com.forum.ForumHub.entity;

import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
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

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioEntity usuario;

//    @ManyToOne
//    @JoinColumn(name = "curso_id")
    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @OneToMany(mappedBy = "topico")
    private List<RespostaEntity> respostas;
//    @Embedded
//    private RespostaEntity resposta;

//    public TopicosEntity(DadosNovoTopicoDto dados, CursoEntity curso, UsuarioEntity autor) {
//        this.titulo = dados.titulo();
//        this.mensagem = dados.mensagem();
//        this.dataCriacao = LocalDateTime.now();
//        this.status = Status.NAO_REPONDIDA;
//        this.curso = curso;
//        this.autor = autor;
//
//        System.out.println("------------------------");
//        System.out.println(LocalDateTime.now());

//    public TopicosEntity(DadosNovoTopicoDto dados) {
//
//        this.titulo = dados.titulo();
//        this.mensagem = dados.mensagem();
//        this.curso = new CursoEntity(dados.curso());
//    }
}
//    public Medico(DadosCadastroMedico dados) {
//        this.ativo = true;
//        this.nome = dados.nome();
//        this.email = dados.email();
//        this.telefone = dados.telefone();
//        this.crm = dados.crm();
//        this.especialidade = dados.especialidade();
//        this.endereco = new Endereco(dados.endereco());
//    }
//
//    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
//        if (dados.nome() != null) {
//            this.nome = dados.nome();
//        }
//        if (dados.telefone() != null) {
//            this.telefone = dados.telefone();
//        }
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