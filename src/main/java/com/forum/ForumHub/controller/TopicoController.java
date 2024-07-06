package com.forum.ForumHub.controller;

import com.forum.ForumHub.domain.topico.dto.DadosNovoTopicoDto;
import com.forum.ForumHub.domain.topico.dto.ListagemDeDadosTopicosDto;
import com.forum.ForumHub.domain.topico.repository.TopicosRepository;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import com.forum.ForumHub.domain.usuario.dto.ListagemDeDadosUsuariosDto;
import com.forum.ForumHub.domain.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topico")
public class TopicoController {

    @Autowired
    private TopicosRepository topicosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public Page<ListagemDeDadosTopicosDto> listarTopicos(@PageableDefault(size = 10, sort = {"titulo", "id"}) Pageable paginacao){

        return topicosRepository.findAll(paginacao)
                .map(ListagemDeDadosTopicosDto::new);
    }

    @Transactional
    @PostMapping
    public void novoTopico(@RequestBody @Valid DadosNovoTopicoDto dados){

        var usuario = usuarioRepository.getReferenceById(dados.id_usuario());

        topicosRepository.save(new TopicosEntity(dados, usuario));
        System.out.println(dados);
    }

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
