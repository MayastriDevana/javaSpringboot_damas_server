package com.damas.dbbcassdmdev.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //berisi setter dan getter
@AllArgsConstructor //biar class bisa di buat menggunakan argumen/params
@NoArgsConstructor //biar class bisa di buat tidak menggunakan argumen/params
@Builder

public class UsersBcasRequest {
    
    @NotBlank
    @Size(max = 100)
    private String nama;

    @NotBlank
    @Size(max = 100)
    private String departemen;

}
