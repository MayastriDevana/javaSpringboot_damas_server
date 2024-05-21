package com.damas.payload;

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

public class LogisticMemoRequest {
    @NotBlank
    @Size(max = 255)
    private String memo_num;

    @NotBlank
    @Size(max = 255)
    private String memo_perihal;

    @NotBlank
    @Size(max = 255)
    private String memo_pic;

    @NotBlank
    @Size(max = 255)
    private String memo_deadline;

    @NotBlank
    @Size(max = 255)
    private String memo_status;


}
