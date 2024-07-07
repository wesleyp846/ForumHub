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
    public ResponseEntity<Page<DetalhesRespostaDTO>> detalharResposta(@PageableDefault(size = 10, sort = {"dataCriacao", "topico"}) Pageable paginacao) {

        var obejeto = repositoryResposta.findAll(paginacao)
                .map(DetalhesRespostaDTO::new);

        return ResponseEntity.ok(obejeto);
    }

    @Transactional
    @PostMapping("/{id}")
    public void criarResposta(@PathVariable Long id, @RequestBody @Valid DtoDadosNovaResposta dados){

        var topico = topicosRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));

        var usuario = usuarioRepository.getReferenceById(dados.id_usuario());

        repositoryResposta.save(new EntityResposta(topico, usuario, dados));
    }

    @Transactional
    @PutMapping("/{id}")
    public void editaResposta(@PathVariable Long id, @RequestBody @Valid EditarRespostaDto dados){

        var resposta = repositoryResposta.getReferenceById(id);
        resposta.editarTopico(dados);
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

//    @PostMapping
//    public ResponseEntity<DetalhesRespostaDTO> criarResposta(@RequestBody @Valid CriaRespostaDTO dto, UriComponentsBuilder uriBuilder) {
//        DetalhesRespostaDTO respostaCriada = respostaService.criarResposta(dto);
//
//        var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(respostaCriada.id()).toUri();
//
//        return ResponseEntity.created(uri).body(respostaCriada);
//    }
}