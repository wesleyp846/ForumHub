package com.forum.ForumHub.domain.auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface AdmRepository extends JpaRepository<AdmEntity, Long> {

    UserDetails findByLogin(String login);
}
