package com.flow.extblocker.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FixedExtBlockDto {
    private String ext;
    private String useYn;

    @Builder
    public FixedExtBlockDto(String ext, String useYn) {
        this.ext = ext;
        this.useYn = useYn;
    }
}
