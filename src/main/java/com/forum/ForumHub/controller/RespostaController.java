package com.forum.ForumHub.controller;

import com.forum.ForumHub.domain.resposta.dto.DetalhesRespostaDTO;
import com.forum.ForumHub.domain.resposta.dto.DtoDadosNovaResposta;
import com.forum.ForumHub.domain.resposta.dto.EditarRespostaDto;
import com.forum.ForumHub.domain.resposta.entity.EntityResposta;
import com.forum.ForumHub.domain.resposta.repository.RepositoryResposta;
import com.forum.ForumHub.domain.topico.repository.TopicosRepository;
import com.forum.ForumHub.domain.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    @Autowired
    private RepositoryResposta repositoryResposta;

    @Autowired
    private TopicosRepository topicosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<Page<DetalhesRespostaDTO>> detalharResposta(
            @PageableDefault(size = 10, sort = {"dataCriacao", "topico"})
            Pageable paginacao) {

        var obejeto = repositoryResposta.findAll(paginacao)
                .map(DetalhesRespostaDTO::new);

        return ResponseEntity.ok(obejeto);
    }

    @Transactional
    @PostMapping("/{id}")
    public ResponseEntity<DtoDadosNovaResposta> criarResposta(
            @PathVariable Long id,
            @RequestBody @Valid DtoDadosNovaResposta dados,
            UriComponentsBuilder uriBulder){

        var topico = topicosRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));

        var usuario = usuarioRepository.getReferenceById(dados.id_usuario());

        var resposta = repositoryResposta.save(new EntityResposta(topico, usuario, dados));

        var uri = uriBulder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();

        return ResponseEntity.created(uri).body(dados);
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<EditarRespostaDto> editaResposta(
            @PathVariable Long id,
            @RequestBody @Valid EditarRespostaDto dados){

        if (repositoryResposta.existsById(id)){

            var resposta = repositoryResposta.getReferenceById(id);
            resposta.editarTopico(dados);

            return ResponseEntity.ok(dados);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity apagaResposta(@PathVariable Long id){

        if (repositoryResposta.existsById(id)){
            repositoryResposta.deleteById(id);
        }else {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
}