package com.flow.extblocker.controller.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FixedExtBlockRequestDto {
    private String ext;
    private String useYn;

    @Builder
    public FixedExtBlockRequestDto(String ext, String useYn) {
        this.ext = ext;
        this.useYn = useYn;
    }
}
