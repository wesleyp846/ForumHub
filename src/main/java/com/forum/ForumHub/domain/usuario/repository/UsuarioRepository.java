package com.forum.ForumHub.domain.usuario.repository;

import com.forum.ForumHub.domain.usuario.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
