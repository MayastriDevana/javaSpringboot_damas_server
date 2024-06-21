package com.damas.dbdamas.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemoApprovalRequest {

    @NotBlank
    @Size(max = 255)
    private String approval_id;

    @NotBlank
    @Size(max = 255)
    private String memo_id;

    @NotBlank
    @Size(max = 255)
    private String approval_status;

    @NotNull
    private MultipartFile approval_upload; // For file upload

    @NotBlank
    @Size(max = 255)
    private String approval_notes;
}
