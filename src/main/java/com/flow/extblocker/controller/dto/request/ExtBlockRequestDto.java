package com.flow.extblocker.controller.dto.request;


import lombok.*;

@Getter
@NoArgsConstructor
public class ExtBlockRequestDto {
    private Long id;
    private String ext;

    @Builder
    public ExtBlockRequestDto(Long id, String ext) {
        isValidation(ext);
        this.id = id;
        this.ext = ext;
    }

    public void setExt(String ext){
       isValidation(ext);
       this.ext = ext;
    }

    public void isValidation(String ext){
        if(ext.length() > 20){
            throw new IllegalArgumentException("확장자의 입력 길이는 20자를 넘을 수 없습니다.");
        }
    }
}
