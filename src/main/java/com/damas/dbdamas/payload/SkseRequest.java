package com.damas.dbdamas.payload;

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

public class SkseRequest {
    @NotBlank
    @Size(max = 100)
    private String nosurat;

    @NotBlank
    @Size(max = 100)
    private String perihal;

    @NotBlank
    @Size(max = 100)
    private String pic;

    @NotBlank
    @Size(max = 100)
    private String departement;

    @NotBlank
    @Size(max = 100)
    private String deadline;

    @NotBlank
    @Size(max = 100)
    private String status;
}
