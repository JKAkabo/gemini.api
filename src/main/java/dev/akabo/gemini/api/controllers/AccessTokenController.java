package dev.akabo.gemini.api.controllers;

import dev.akabo.gemini.api.dtos.AccessTokenCreateDto;
import dev.akabo.gemini.api.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class AccessTokenController {
    private final AuthenticationManager authenticationManager;

    @PostMapping("/access-tokens")
    public User createAccessToken(@Valid @RequestBody AccessTokenCreateDto dto) {
        Authentication authenticate = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                dto.getUsername(), dto.getPassword()
                        )
                );

        return (User) authenticate.getPrincipal();
    }
}
