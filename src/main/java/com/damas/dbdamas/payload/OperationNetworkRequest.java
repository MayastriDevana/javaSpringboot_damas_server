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

public class OperationNetworkRequest {
    @NotBlank
    @Size(max = 255)
    private String network_perihal;

    @NotBlank
    @Size(max = 255)
    private String network_pic;

    @NotBlank
    @Size(max = 255)
    private String network_deadline;

    @NotBlank
    @Size(max = 255)
    private String network_status;


}
