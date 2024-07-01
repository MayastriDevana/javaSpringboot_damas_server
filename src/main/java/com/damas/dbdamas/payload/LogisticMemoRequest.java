package com.damas.dbdamas.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data // Includes getters and setters
@AllArgsConstructor // Allows instantiation with arguments
@NoArgsConstructor // Allows instantiation without arguments
@Builder
public class LogisticMemoRequest {

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
    private String memo_department;

    @NotBlank
    @Size(max = 255)
    private String memo_createdBy;

    @NotBlank
    @Size(max = 255)
    private String memo_reviewer;

    @NotBlank
    @Size(max = 255)
    private String memo_status;

    
    // For file uploads, consider using MultipartFile or a similar approach
    private String memo_upload; // Field for storing uploaded files


    // @PastOrPresent
    private String memo_deadline;

    @Size(max = 1000)
    private String memo_notes; // Optional field, can store longer text

    @Size(max = 100)
    private String userdomain;

    @Size(max = 100)
    private String userdomainpic;

    @Size(max = 100)
    private String userdomainreviewer;



}
