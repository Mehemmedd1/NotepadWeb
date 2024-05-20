package com.NotepadWeb.NotepadWebBackEnd.Entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponse {
    private final  String accessToken;

}
