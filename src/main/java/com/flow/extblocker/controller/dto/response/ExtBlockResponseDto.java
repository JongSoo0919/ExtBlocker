package com.flow.extblocker.controller.dto.response;

import com.flow.extblocker.entity.ext.ExtBlockEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExtBlockResponseDto {
    private Long id;
    private String ext;

    @Builder
    public ExtBlockResponseDto(Long id, String ext) {
        this.id = id;
        this.ext = ext;
    }
    public static ExtBlockResponseDto of(ExtBlockEntity entity){
        return ExtBlockResponseDto.builder()
                .id(entity.getId())
                .ext(entity.getExt())
                .build();
    }
}
