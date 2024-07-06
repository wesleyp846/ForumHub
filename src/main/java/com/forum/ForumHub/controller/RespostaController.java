package com.forum.ForumHub.controller;

import com.forum.ForumHub.domain.resposta.dto.DtoDadosNovaResposta;
import com.forum.ForumHub.domain.resposta.entity.EntityResposta;
import com.forum.ForumHub.domain.resposta.repository.RepositoryResposta;
import com.forum.ForumHub.domain.topico.repository.TopicosRepository;
import com.forum.ForumHub.domain.usuario.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resposta")
public class RespostaController {

    @Autowired
    private RepositoryResposta repositoryResposta;

    @Autowired
    private TopicosRepository topicosRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;


//    @GetMapping("/{id}")
//    public ResponseEntity<DetalhesRespostaDTO> detalharResposta(@PathVariable Long id) {
//        DetalhesRespostaDTO detalhesResposta = respostaService.detalharResposta(id);
//        return ResponseEntity.ok(detalhesResposta);
//    }
    @Transactional
    @PostMapping("/{id}")
    public void criarResposta(@PathVariable Long id, @RequestBody @Valid DtoDadosNovaResposta dados){

        var topico = topicosRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Tópico não encontrado"));

        var usuario = usuarioRepository.getReferenceById(dados.id_usuario());

        repositoryResposta.save(new EntityResposta(topico, usuario, dados));
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