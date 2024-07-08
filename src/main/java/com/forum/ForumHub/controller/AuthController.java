package com.forum.ForumHub.controller;

import com.forum.ForumHub.domain.auth.AdmEntity;
import com.forum.ForumHub.domain.auth.EnvioAutenticacaoDTO;
import com.forum.ForumHub.infra.segurancaConfig.TokenService;
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

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efeturarLogin(@RequestBody @Valid EnvioAutenticacaoDTO dados){

        var token = new UsernamePasswordAuthenticationToken(
                dados.login(),
                dados.senha());

        var autenticacao = manager.authenticate(token);

        return ResponseEntity.ok(tokenService.gerarToken((AdmEntity) autenticacao.getPrincipal()));
    }
}
