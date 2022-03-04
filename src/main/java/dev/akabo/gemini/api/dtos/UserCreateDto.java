package dev.akabo.gemini.api.dtos;

import dev.akabo.gemini.api.enums.Permission;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserCreateDto {
    @NotEmpty
    @Size(max = 25)
    private String firstName;
    @NotEmpty
    @Size(max = 25)
    private String lastName;
    @NotEmpty
    @Size(min = 4, max = 12)
    private String username;
    @NotEmpty
    @Size(min = 8, max = 16)
    private String password;
    @NotNull
    private List<Permission> permissions = new ArrayList<>();
}
