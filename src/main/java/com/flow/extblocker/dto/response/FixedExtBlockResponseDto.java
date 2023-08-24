package com.flow.extblocker.dto.response;

import com.flow.extblocker.entity.ext.FixedExtBlockEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class FixedExtBlockResponseDto {
    private Long id;
    private String ext;
    private String useYn;

    @Builder
    public FixedExtBlockResponseDto(Long id, String ext, String useYn) {
        this.id = id;
        this.ext = ext;
        this.useYn = useYn;
    }

    public static FixedExtBlockResponseDto of(FixedExtBlockEntity entity){
        return FixedExtBlockResponseDto.builder()
                .id(entity.getId())
                .ext(entity.getExt())
                .useYn(entity.getUseYn())
                .build();
    }
}
