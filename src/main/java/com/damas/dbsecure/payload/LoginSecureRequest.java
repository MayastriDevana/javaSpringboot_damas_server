package com.damas.dbsecure.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginSecureRequest {

    @NotBlank
    @Size(max = 100)
    private String userid;

    @NotBlank
    @Size(max = 100)
    private String pass;
}
