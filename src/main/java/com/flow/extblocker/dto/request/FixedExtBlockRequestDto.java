package com.flow.extblocker.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FixedExtBlockRequestDto {
    private Long id;
    private String ext;
    private String useYn;

    @Builder
    public FixedExtBlockRequestDto(Long id, String ext, String useYn) {
        this.id = id;
        this.ext = ext;
        this.useYn = useYn;
    }
}
