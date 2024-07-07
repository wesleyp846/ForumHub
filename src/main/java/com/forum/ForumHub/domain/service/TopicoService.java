package com.forum.ForumHub.domain.service;

import com.forum.ForumHub.domain.topico.dto.DadosNovoTopicoDto;
import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import com.forum.ForumHub.domain.topico.repository.TopicosRepository;
import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    @Autowired
    private TopicosRepository topicosRepository;

    public void validarTopicoDuplicado(DadosNovoTopicoDto dadosNovoTopicoDto) {
        boolean exists = topicosRepository.existsByTituloAndMensagem(
                dadosNovoTopicoDto.titulo(), dadosNovoTopicoDto.mensagem());
        if (exists) {
            throw new RuntimeException("Tópico duplicado: título e mensagem já existem.");
        }
    }

    public TopicosEntity criarNovoTopico(DadosNovoTopicoDto dadosNovoTopicoDto, UsuarioEntity usuario) {
        validarTopicoDuplicado(dadosNovoTopicoDto);
        TopicosEntity novoTopico = new TopicosEntity(
                dadosNovoTopicoDto.titulo(),
                dadosNovoTopicoDto.mensagem(),
                dadosNovoTopicoDto.curso(),
                usuario);
        return topicosRepository.save(novoTopico);
    }

}