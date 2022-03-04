package dev.akabo.gemini.api.controllers;

import dev.akabo.gemini.api.dtos.UserCreateDto;
import dev.akabo.gemini.api.resources.UserResource;
import dev.akabo.gemini.api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "/users")
@RequiredArgsConstructor
@Validated
public class UserController {
    private final UserService userService;

    @PostMapping
    @Transactional
    public UserResource createUser(@Valid @RequestBody UserCreateDto dto) {
        return new UserResource(userService.save(dto));
    }
}
