package com.damas.dbdamas.payload.Projectdev;

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
    private String deadlineskse;

  
    @Size(max = 100)
    private String status;

    @Size(max = 100)
    private String userdomain;

    @Size(max = 100)
    private String userdomainpic;

    @Size(max = 100)
    private String createdby;
    
}
