package com.forum.ForumHub.domain.topico.repository;

import com.forum.ForumHub.domain.topico.entity.TopicosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicosRepository extends JpaRepository<TopicosEntity, Long> {

    boolean existsByTituloAndMensagem(String titulo, String mensagem);
}
