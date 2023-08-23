package com.flow.extblocker.controller.service.impl;

import com.flow.extblocker.controller.dto.request.ExtBlockRequestDto;
import com.flow.extblocker.controller.dto.response.ExtBlockResponseDto;
import com.flow.extblocker.controller.service.ext;
import com.flow.extblocker.entity.ext.ExtBlockEntity;
import com.flow.extblocker.repository.ExtBlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 커스텀 확장자는 아래 기능을 가진다
 * read, save, delete
 */
@Service
@RequiredArgsConstructor
public class CustomExtImpl implements ext {
    private final ExtBlockRepository extBlockRepository;
    public List<ExtBlockResponseDto> readAll(){
        List<ExtBlockEntity> entities = extBlockRepository.findAll();
        return entities.stream()
                .map(entity -> ExtBlockResponseDto.of(entity))
                .collect(Collectors.toList());
    }
    public Long save(ExtBlockRequestDto dto){
        return extBlockRepository.save(
                ExtBlockEntity.of(dto)
        ).getId();
    }
    public void delete(Long id){
        extBlockRepository.deleteById(id);
    }

}
