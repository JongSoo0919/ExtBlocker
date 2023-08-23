package com.flow.extblocker.controller.rest;

import com.flow.extblocker.controller.dto.request.FixedExtBlockRequestDto;
import com.flow.extblocker.controller.dto.response.FixedExtBlockResponseDto;
import com.flow.extblocker.controller.service.ext;
import com.flow.extblocker.controller.service.impl.FixedExtImpl;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class FixedExtController {
    private final FixedExtImpl fixedExtImpl;

    @GetMapping("/api/fixed/ext")
    public ResponseEntity<List<FixedExtBlockResponseDto>> getAll(
            HttpServletRequest request
    ){
        log.info("[rest] fixed list 호출");

        return ResponseEntity.ok(fixedExtImpl.readAll());
    }
    @PostMapping("/api/fixed/ext")
    public Long save(
            HttpServletRequest request,
            FixedExtBlockRequestDto dto
    ){
        return fixedExtImpl.save(dto);
    }
    @DeleteMapping("/api/fixed/ext/{id}")
    public void delete(
            HttpServletRequest request,
            @PathVariable Long id
    ) {
        fixedExtImpl.delete(id);
    }
    @PutMapping("/api/fixed/ext/{id}")
    public void update(
            HttpServletRequest request,
            @PathVariable Long id,
            FixedExtBlockRequestDto dto
    ) {
        fixedExtImpl.update(id, dto);
    }
}
