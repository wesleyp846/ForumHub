package com.forum.ForumHub.controller;

import com.forum.ForumHub.dto.DadosNovoUsuarioDto;
import com.forum.ForumHub.dto.ListagemDeDadosUsuariosDto;
import com.forum.ForumHub.entity.UsuarioEntity;
import com.forum.ForumHub.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<ListagemDeDadosUsuariosDto> listaUsuario(){

        return usuarioRepository.findAll()
                .stream()
                .map(ListagemDeDadosUsuariosDto::new)
                .toList();
    }

    @Transactional
    @PostMapping
    public void novoUsuario(@RequestBody @Valid DadosNovoUsuarioDto dados){

        usuarioRepository.save(new UsuarioEntity(dados));
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
