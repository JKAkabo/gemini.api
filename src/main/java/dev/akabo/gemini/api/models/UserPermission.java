package dev.akabo.gemini.api.models;

import dev.akabo.gemini.api.enums.Permission;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(UserPermission.PermissionId.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserPermission implements GrantedAuthority {
    @Id
    private Integer userId;
    @Id
    @Enumerated(EnumType.STRING)
    private Permission permission;

    @Override
    public String getAuthority() {
        return permission.name();
    }

    public record PermissionId(Integer userId, Permission permission) implements Serializable {
    }
}
