package com.forum.ForumHub.controller;

import com.forum.ForumHub.domain.topico.dto.DadosNovoTopicoDto;
import com.forum.ForumHub.domain.topico.dto.DetalhaTopicoDTO;
import com.forum.ForumHub.domain.topico.dto.EditarTopicoDto;
import com.forum.ForumHub.domain.topico.dto.ListagemDeDadosTopicosDto;
import com.forum.ForumHub.domain.topico.repository.TopicosRepository;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import com.forum.ForumHub.domain.usuario.dto.DadosEdicaoDeUsuarioDto;
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

    @GetMapping("/{id}")
    public ResponseEntity detalhaTopico(@PathVariable Long id){

            var topico = topicosRepository.getReferenceById(id);

            return ResponseEntity.ok(new DetalhaTopicoDTO(topico));
    }

    @Transactional
    @PostMapping
    public void novoTopico(@RequestBody @Valid DadosNovoTopicoDto dados){

        var usuario = usuarioRepository.getReferenceById(dados.id_usuario());

        topicosRepository.save(new TopicosEntity(dados, usuario));
    }

    @Transactional
    @PutMapping("/{id}")
    public void editarTopico(@PathVariable Long id, @RequestBody @Valid EditarTopicoDto dados){

        var topico = topicosRepository.getReferenceById(id);
        topico.editarTopico(dados);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void dasativartopico(@PathVariable Long id){

        topicosRepository.deleteById(id);
    }

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
}
