package com.santanu.TastyTracks.response;

import com.santanu.TastyTracks.domain.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {
    private String message;
    private String jwt;
    private USER_ROLE role;
}