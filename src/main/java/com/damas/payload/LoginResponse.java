package com.damas.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class LoginResponse {
    private String username;
    private String name;
    private String role;
    private String token;
    
}
