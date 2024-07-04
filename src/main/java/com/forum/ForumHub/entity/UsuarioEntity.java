package com.forum.ForumHub.entity;

import com.forum.ForumHub.dto.DadosEdicaoDeUsuarioDto;
import com.forum.ForumHub.dto.DadosNovoUsuarioDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id;

    private String nome;
    private String email;
    private String senha;

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