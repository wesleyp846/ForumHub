package com.forum.ForumHub.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
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
    private Status status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private UsuarioEntity autor;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;

    @OneToMany(mappedBy = "topico")
    private List<RespostaEntity> respostas;

}
//    @Enumerated(EnumType.STRING)
//    private Especialidade especialidade;
//
//    @Embedded
//    private Endereco endereco;
//
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