package com.damas.dbbcassdmdev.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor 
@Builder //untuk membuat object user response

public class UsersBcasResponse {
    private String nama;
    private String departemen;
    private String userdomain;
}
