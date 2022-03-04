package dev.akabo.gemini.api.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccessTokenCreateDto {
    private String username;
    private String password;
}
