package com.flow.extblocker.entity.ext;

import com.flow.extblocker.controller.dto.FixedExtBlockDto;
import com.flow.extblocker.repository.FixedExtBlockRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FixedExtBlockEntityTest {
    @Autowired
    private FixedExtBlockRepository fixedExtBlockRepository;

    @BeforeEach
    public void init(){
        List<FixedExtBlockDto> dtos = List.of(
                FixedExtBlockDto.builder()
                        .ext("bat")
                        .useYn("N")
                        .build()
                ,FixedExtBlockDto.builder()
                        .ext("cmd")
                        .useYn("N")
                        .build()
                ,FixedExtBlockDto.builder()
                        .ext("com")
                        .useYn("N")
                        .build()
                ,FixedExtBlockDto.builder()
                        .ext("cpl")
                        .useYn("N")
                        .build()
                ,FixedExtBlockDto.builder()
                        .ext("ext")
                        .useYn("N")
                        .build()
                ,FixedExtBlockDto.builder()
                        .ext("scr")
                        .useYn("N")
                        .build()
                ,FixedExtBlockDto.builder()
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