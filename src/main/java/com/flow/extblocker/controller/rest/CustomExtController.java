package com.flow.extblocker.controller.rest;

import com.flow.extblocker.dto.request.ExtBlockRequestDto;
import com.flow.extblocker.dto.response.ExtBlockResponseDto;
import com.flow.extblocker.service.impl.CustomExtImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CustomExtController {
    private final CustomExtImpl customExtImpl;
    @GetMapping("/api/custom/ext-count")
    public ResponseEntity<Long> getCount(){
        return ResponseEntity.ok(customExtImpl.readCount());
    }

    @GetMapping("/api/custom/ext")
    public ResponseEntity<List<ExtBlockResponseDto>> getAll(
            HttpServletRequest request
    ){
        log.info("[rest] custom list 호출");

        return ResponseEntity.ok(customExtImpl.readAll());
    }
    @PostMapping("/api/custom/ext")
    public Long save(
            HttpServletRequest request,
            @RequestBody ExtBlockRequestDto dto
    ) {
        return customExtImpl.save(dto);
    }

    @DeleteMapping("/api/custom/ext/{id}")
    public void delete(
            HttpServletRequest request,
            @PathVariable Long id
    ) {
        customExtImpl.delete(id);
    }
}
