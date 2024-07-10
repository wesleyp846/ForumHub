package com.forum.ForumHub.controller;

import com.forum.ForumHub.domain.resposta.dto.RespostaDTO;
import com.forum.ForumHub.domain.service.TopicoService;
import com.forum.ForumHub.domain.topico.dto.*;
import com.forum.ForumHub.domain.topico.repository.TopicosRepository;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import com.forum.ForumHub.domain.usuario.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicosRepository topicosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TopicoService topicoService;

    @GetMapping
    public ResponseEntity<Page<ListagemDeDadosTopicosDto>> listarTopicos(
            @PageableDefault(size = 10, sort = {"dataCriacao"},
                    direction = Sort.Direction.ASC) Pageable paginacao){

        var objeto =  topicosRepository.findAll(paginacao)
                .map(ListagemDeDadosTopicosDto::new);

        return ResponseEntity.ok(objeto);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhaTopico(@PathVariable Long id) {

        var topico = topicosRepository.getReferenceById(id);
        var usuario = topico.getUsuario();
        var usuarioNome = usuario.getNome();

//        Filtrar respostas pelo mesmo usuário e converter para RespostaDTO
        var respostasDTO = topico.getRespostas().stream()
//                Aqui é filtrado para exibir apenas repostas do mesmo usuario do topico
//                .filter(resposta -> resposta.getUsuario().equals(usuario))
                .map(RespostaDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new DetalhaTopicoDTO(topico, usuarioNome, respostasDTO));
    }

    @PostMapping
    public ResponseEntity<DadosNovoTopicoDto> criarNovoTopico(@RequestBody
                                                             @Valid DadosNovoTopicoDto dadosNovoTopicoDto,
                                                              UriComponentsBuilder uriBulder) {

        var usuario = usuarioRepository.getReferenceById(dadosNovoTopicoDto.id_usuario());
        TopicosEntity novoTopico = topicoService.criarNovoTopico(dadosNovoTopicoDto, usuario);

        var uri = uriBulder.path("/topicos/{id}").buildAndExpand(novoTopico.getId()).toUri();

        return ResponseEntity.created(uri).body(dadosNovoTopicoDto);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<RespostaEditaTopicoDTO> editarTopico(
            @PathVariable Long id,
            @RequestBody @Valid EditarTopicoDto dados){

        if (topicosRepository.existsById(id)){
            var topico = topicosRepository.getReferenceById(id);
            topico.editarTopico(dados);

            return ResponseEntity.ok(new RespostaEditaTopicoDTO(topico));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity dasativartopico(@PathVariable Long id){

        if (topicosRepository.existsById(id)){
            topicosRepository.deleteById(id);
        }else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}
