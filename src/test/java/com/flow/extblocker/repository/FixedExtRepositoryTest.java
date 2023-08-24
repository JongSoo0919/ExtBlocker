package com.flow.extblocker.repository;

import com.flow.extblocker.dto.request.FixedExtBlockRequestDto;
import com.flow.extblocker.entity.ext.FixedExtBlockEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;

@DataJpaTest
class FixedExtRepositoryTest {
    @Autowired
    private FixedExtBlockRepository fixedExtBlockRepository;

    @BeforeEach
    public void init(){
        List<FixedExtBlockRequestDto> dtos = List.of(
                FixedExtBlockRequestDto.builder()
                        .ext("bat")
                        .useYn("N")
                        .build()
                , FixedExtBlockRequestDto.builder()
                        .ext("cmd")
                        .useYn("N")
                        .build()
                , FixedExtBlockRequestDto.builder()
                        .ext("com")
                        .useYn("N")
                        .build()
                , FixedExtBlockRequestDto.builder()
                        .ext("cpl")
                        .useYn("N")
                        .build()
                , FixedExtBlockRequestDto.builder()
                        .ext("ext")
                        .useYn("N")
                        .build()
                , FixedExtBlockRequestDto.builder()
                        .ext("scr")
                        .useYn("N")
                        .build()
                , FixedExtBlockRequestDto.builder()
                        .ext("js")
                        .useYn("N")
                        .build()
        );
        List<FixedExtBlockEntity> entities = dtos.stream()
                .map(dto -> FixedExtBlockEntity.of(dto))
                .collect(Collectors.toList());
        fixedExtBlockRepository.saveAll(entities);
    }

    @DisplayName("고정 확장자 확인")
    @Test
    public void selectAll(){
        List<FixedExtBlockEntity> entities = fixedExtBlockRepository.findAll();

        Assertions.assertThat(entities).isNotNull();
        entities.forEach(System.out::println);
    }
}