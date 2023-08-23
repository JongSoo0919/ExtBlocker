package com.flow.extblocker.controller.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ExtBlockDto {
    private String ext;

    @Builder
    public ExtBlockDto(String ext) {
        this.ext = ext;
    }
}
