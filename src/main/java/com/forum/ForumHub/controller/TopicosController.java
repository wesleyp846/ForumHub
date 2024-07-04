package com.forum.ForumHub.controller;

import com.forum.ForumHub.dto.DadosNovoTopicoDto;
import com.forum.ForumHub.dto.DadosNovoUsuarioDto;
import com.forum.ForumHub.dto.ListagemDeTodosOsTopicosDto;

import com.forum.ForumHub.entity.TopicosEntity;
import com.forum.ForumHub.repository.CursoRepository;
import com.forum.ForumHub.repository.TopicosRepository;
import com.forum.ForumHub.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

//    @Autowired
//    private TopicosRepository topicosRepository;
//
//    @Autowired
//    private CursoRepository cursoRepository;
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String helloMundo(){

        return "Primeiro controller";
    }

//    @PostMapping
//    public void novoUsuario(@RequestBody @Valid DadosNovoUsuarioDto dados){
//
//        System.out.println(dados);
//    }

//    @PostMapping
//    public void novoTopico(@RequestBody DadosNovoTopicoDto dados){

//    public TopicosEntity criarTopico(DadosNovoTopicoDto dados, Long autorId) {
//        CursoEntity curso = cursoRepository.findById(dados.cursoId())
//                .orElseThrow(() -> new EntityNotFoundException("Curso não encontrado"));
//
//        UsuarioEntity autor = usuarioRepository.findById(autorId)
//                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
//
//        TopicosEntity topico = new TopicosEntity(dados, curso, autor);
//        return topicoRepository.save(topico);
//    }

//        topicosRepository.save(new TopicosEntity(dados));
//        System.out.println(dados);
//    }

//    public ResponseEntity<ListagemDeTodosOsTopicosDto> listar(){
//
//        var page = "repository";
//
//        return ResponseEntity.ok(page);
//
//    }

//    @GetMapping
//    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
//        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
//        return ResponseEntity.ok(page);
//    }
}
