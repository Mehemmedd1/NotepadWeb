package com.NotepadWeb.NotepadWebBackEnd.Service;


import com.NotepadWeb.NotepadWebBackEnd.Entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private static final String EXISTING_EMAIL = "test@test.com";
    private static final String ANOTHER_EMAIL = "next@test.com";

    public Optional<UserEntity> findByEmail(String email) {
        if (EXISTING_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId(1L);
            user.setEmail(EXISTING_EMAIL);
            user.setPassword("$2a$12$5OTq8hiHOyTBOpBQ0sEqZu8oGNVcafl/9kUgvNynRx37VTdRhlWwe");
            user.setRole("ROLE_ADMIN");
            user.setExtraInfo("Hello admin");
            return Optional.of(user);
        } else if (ANOTHER_EMAIL.equalsIgnoreCase(email)) {
            var user = new UserEntity();
            user.setId(99L);
            user.setEmail(ANOTHER_EMAIL);
            user.setPassword("$2a$12$5OTq8hiHOyTBOpBQ0sEqZu8oGNVcafl/9kUgvNynRx37VTdRhlWwe");
            user.setRole("ROLE_USER");
            user.setExtraInfo("Hello user");
            return Optional.of(user);
        }
        return Optional.empty();

    }
}
