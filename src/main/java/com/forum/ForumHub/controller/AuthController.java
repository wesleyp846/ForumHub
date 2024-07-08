package com.forum.ForumHub.controller;

import com.forum.ForumHub.domain.auth.EnvioAutenticacaoDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping
    public ResponseEntity efeturarLogin(@RequestBody @Valid EnvioAutenticacaoDTO dados){

        var token = new UsernamePasswordAuthenticationToken(
                dados.login(),
                dados.senha());

        var autenticacao = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
