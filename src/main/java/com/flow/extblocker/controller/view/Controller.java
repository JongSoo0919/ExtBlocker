package com.flow.extblocker.controller.view;

import com.flow.extblocker.controller.dto.response.FixedExtBlockResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@org.springframework.stereotype.Controller
@Slf4j
public class Controller {
    //TODO : 테이블 데이터로 변경
    public final List<FixedExtBlockResponseDto> list = List.of(
            FixedExtBlockResponseDto.builder()
                    .id(1L)
                    .ext("bat")
                    .useYn("N")
                    .build()
            , FixedExtBlockResponseDto.builder()
                    .id(2L)
                    .ext("cmd")
                    .useYn("N")
                    .build()
            , FixedExtBlockResponseDto.builder()
                    .id(3L)
                    .ext("com")
                    .useYn("N")
                    .build()
            , FixedExtBlockResponseDto.builder()
                    .id(4L)
                    .ext("cpl")
                    .useYn("N")
                    .build()
            , FixedExtBlockResponseDto.builder()
                    .id(5L)
                    .ext("ext")
                    .useYn("N")
                    .build()
            , FixedExtBlockResponseDto.builder()
                    .id(6L)
                    .ext("scr")
                    .useYn("N")
                    .build()
            , FixedExtBlockResponseDto.builder()
                    .id(7L)
                    .ext("js")
                    .useYn("N")
                    .build()
    );

    @GetMapping("/")
    public String index(
            HttpServletRequest request,
            Model model
    ) {
        log.info("[View] index Controller 진입");
        model.addAttribute("fixedExts", list);
        return "index";
    }
}
