package dev.akabo.gemini.api.services;

import dev.akabo.gemini.api.dtos.UserCreateDto;
import dev.akabo.gemini.api.enums.Permission;
import dev.akabo.gemini.api.models.User;
import dev.akabo.gemini.api.models.UserPermission;
import dev.akabo.gemini.api.repos.UserPermissionRepo;
import dev.akabo.gemini.api.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final UserPermissionRepo userPermissionRepo;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User save(UserCreateDto dto) {
        User user = userRepo.save(User.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .username(dto.getUsername())
                .password(passwordEncoder.encode(dto.getPassword()))
                .build());
        for (Permission permission : dto.getPermissions()) {
            userPermissionRepo.save(UserPermission.builder()
                    .userId(user.getId())
                    .permission(permission)
                    .build());
        }
        return user;
    }
}
