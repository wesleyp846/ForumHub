package com.forum.ForumHub.domain.usuario.entity;

import com.forum.ForumHub.domain.resposta.entity.EntityResposta;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import com.forum.ForumHub.domain.usuario.dto.DadosEdicaoDeUsuarioDto;
import com.forum.ForumHub.domain.usuario.dto.DadosNovoUsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<TopicosEntity> topicos;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<EntityResposta> respostas;

    public UsuarioEntity(DadosNovoUsuarioDto dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.senha = dados.senha();
    }

    public void editarUsuario(DadosEdicaoDeUsuarioDto dados) {

        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.email() != null){
            this.email = dados.email();
        }
    }

//    @ManyToMany
//    @JoinTable(
//            name = "usuario_perfil",
//            joinColumns = @JoinColumn(name = "usuario_id"),
//            inverseJoinColumns = @JoinColumn(name = "perfil_id")
//    )
//    private List<PerfilEntity> perfis;
}