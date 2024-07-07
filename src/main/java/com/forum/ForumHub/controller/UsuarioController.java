package com.forum.ForumHub.controller;

import com.forum.ForumHub.domain.usuario.dto.DadosEdicaoDeUsuarioDto;
import com.forum.ForumHub.domain.usuario.dto.DadosNovoUsuarioDto;
import com.forum.ForumHub.domain.usuario.dto.ListagemDeDadosUsuariosDto;
import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;
import com.forum.ForumHub.domain.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<Page<ListagemDeDadosUsuariosDto>> listaUsuario(
            @PageableDefault(size = 10, sort = {"nome", "id"})
            Pageable paginacao){

        var objeto = usuarioRepository.findAll(paginacao)
                .map(ListagemDeDadosUsuariosDto::new);

        return ResponseEntity.ok(objeto);
    }

    @Transactional
    @PostMapping
    public void novoUsuario(@RequestBody @Valid DadosNovoUsuarioDto dados){

        usuarioRepository.save(new UsuarioEntity(dados));
    }

    @Transactional
    @PutMapping("/{id}")
    public void editarUsuario(@PathVariable Long id, @RequestBody @Valid DadosEdicaoDeUsuarioDto dados){

        //var usuario = usuarioRepository.getReferenceById(dados.id());
        var usuario = usuarioRepository.getReferenceById(id);

        usuario.editarUsuario(dados);
    }
//        var topico = topicosRepository.getReferenceById(id);
//        topico.editarTopico(dados);
//    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity dasativarUsuario(@PathVariable Long id){

        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

//    @Transactional
//    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder) {
//        var paciente = new Paciente(dados);
//        repository.save(paciente);
//
//        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
//        return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
//    }
}
