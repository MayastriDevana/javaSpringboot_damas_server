package com.damas.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class OperationSystemRequest {
    @NotBlank
    @Size(max = 255)
    private String system_name;

    @NotBlank
    @Size(max = 255)
    private String system_desc;

    @NotBlank
    @Size(max = 255)
    private String system_threshold_1;

    @NotBlank
    @Size(max = 255)
    private String system_threshold_2;

    @NotBlank
    @Size(max = 255)
    private String system_threshold_3;
}
