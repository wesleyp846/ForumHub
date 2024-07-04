package com.forum.ForumHub.controller;

import com.forum.ForumHub.dto.DadosNovoTopicoDto;
import com.forum.ForumHub.dto.ListagemDeTodosOsTopicosDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @GetMapping
    public String helloMundo(){

        return "Primeiro controller";
    }

    @PostMapping
    public void novoTopico(@RequestBody DadosNovoTopicoDto dados){

        System.out.println(dados);
    }

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
