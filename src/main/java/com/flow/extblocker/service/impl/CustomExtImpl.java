package com.flow.extblocker.service.impl;

import com.flow.extblocker.constant.FixedExt;
import com.flow.extblocker.dto.request.ExtBlockRequestDto;
import com.flow.extblocker.dto.response.ExtBlockResponseDto;
import com.flow.extblocker.service.ext;
import com.flow.extblocker.entity.ext.ExtBlockEntity;
import com.flow.extblocker.repository.ExtBlockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
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
        if(Arrays.stream(FixedExt.values())
                .map(ext -> ext.name())
                .collect(Collectors.toList())
                .contains(dto.getExt())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "고정 확장자는 커스텀 확장자로 추가할 수 없습니다.");
        }

        if(extBlockRepository.count() > 200){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "커스텀 확장자는 200개를 넘을 수 없습니다.");
        }

        if(extBlockRepository.findByExt(dto.getExt()).isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "중복된 확장자가 있습니다.");
        }

        return extBlockRepository.save(
                ExtBlockEntity.of(dto)
        ).getId();
    }
    public void delete(Long id){
        extBlockRepository.deleteById(id);
    }

    public Long readCount() {
        return extBlockRepository.count();
    }
}
