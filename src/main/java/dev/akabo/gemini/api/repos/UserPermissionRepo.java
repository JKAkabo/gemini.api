package dev.akabo.gemini.api.repos;

import dev.akabo.gemini.api.models.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPermissionRepo extends JpaRepository<UserPermission, UserPermission.PermissionId> {
}
