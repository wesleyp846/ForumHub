package com.forum.ForumHub.controller;

import com.forum.ForumHub.dto.DadosEdicaoDeUsuarioDto;
import com.forum.ForumHub.dto.DadosNovoUsuarioDto;
import com.forum.ForumHub.dto.ListagemDeDadosUsuariosDto;
import com.forum.ForumHub.entity.UsuarioEntity;
import com.forum.ForumHub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public Page<ListagemDeDadosUsuariosDto> listaUsuario(@PageableDefault(size = 10, sort = {"nome", "id"}) Pageable paginacao){

        return usuarioRepository.findAll(paginacao)
                .map(ListagemDeDadosUsuariosDto::new);
    }

    @Transactional
    @PostMapping
    public void novoUsuario(@RequestBody @Valid DadosNovoUsuarioDto dados){

        usuarioRepository.save(new UsuarioEntity(dados));
    }

    @Transactional
    @PutMapping
    public void editarUsuario(@RequestBody @Valid DadosEdicaoDeUsuarioDto dados){

        var usuario = usuarioRepository.getReferenceById(dados.id());

        usuario.editarUsuario(dados);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void dasativarUsuario(@PathVariable Long id){

        usuarioRepository.deleteById(id);
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
