package dev.akabo.gemini.api.resources;

import dev.akabo.gemini.api.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserResource extends Resource {
    private String firstName;
    private String lastName;
    private String username;

    public UserResource(User user) {
        this(user, new ArrayList<>());
    }

    public UserResource(User user, List<Rel> rels) {
        super(rels);
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.username = user.getUsername();
    }
}
