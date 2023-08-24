package com.flow.extblocker.service.impl;

import com.flow.extblocker.dto.request.FixedExtBlockRequestDto;
import com.flow.extblocker.dto.response.FixedExtBlockResponseDto;
import com.flow.extblocker.entity.ext.FixedExtBlockEntity;
import com.flow.extblocker.repository.FixedExtBlockRepository;
import com.flow.extblocker.service.ext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 고정 확장자는 아래 기능을 가진다
 * read, save, update, delete
 */
@Service
@RequiredArgsConstructor
public class FixedExtImpl implements ext {
    private final FixedExtBlockRepository fixedExtBlockRepository;
    public List<FixedExtBlockResponseDto> readAll(){
        List<FixedExtBlockEntity> entities = fixedExtBlockRepository.findAll();
        return entities.stream()
                .map(entity -> FixedExtBlockResponseDto.of(entity))
                .collect(Collectors.toList());
    }
    public Long save(FixedExtBlockRequestDto dto){
        return fixedExtBlockRepository.save(
                FixedExtBlockEntity.of(dto)
        ).getId();
    }
    public void delete(Long id){
        fixedExtBlockRepository.deleteById(id);
    }
    public void update(Long id, FixedExtBlockRequestDto dto){
        FixedExtBlockEntity entity = fixedExtBlockRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("변경할 대상 ID가 없습니다."));
        entity.update(dto.getExt(), dto.getUseYn());
        fixedExtBlockRepository.flush(); // 빼도 되는지 여부
    }
}
