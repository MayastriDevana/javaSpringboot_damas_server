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

    @Size(max = 100)
    private String id;
    
  
    @Size(max = 100)
    private String nosurat;

   
    @Size(max = 100)
    private String perihal;

   
    @Size(max = 100)
    private String pic;

    @Size(max = 100)
    private String departement;

   
    @Size(max = 100)
    private String deadline;

  
    @Size(max = 100)
    private String status;
}
