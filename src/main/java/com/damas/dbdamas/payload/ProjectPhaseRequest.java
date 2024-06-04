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

public class ProjectPhaseRequest {
    

    @NotBlank
    @Size(max = 100)
    private String kickoff;

    @NotBlank
    @Size(max = 100)
    private String userrequirement;

    @NotBlank
    @Size(max = 100)
    private String applicationdevelopment;

    @NotBlank
    @Size(max = 100)
    private String sit;

    @NotBlank
    @Size(max = 100)
    private String uat;

    @NotBlank
    @Size(max = 100)
    private String implementationprepare;

    @NotBlank
    @Size(max = 100)
    private String implementationmeeting;
    
    @NotBlank
    @Size(max = 100)
    private String implementation;

    @NotBlank
    @Size(max = 100)
    private String 	postimplementationreview;

    @NotBlank
    @Size(max = 100)
    private String status;
    
}
