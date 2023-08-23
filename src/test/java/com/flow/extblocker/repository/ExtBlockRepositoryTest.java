package com.flow.extblocker.repository;

import com.flow.extblocker.controller.dto.request.ExtBlockRequestDto;
import com.flow.extblocker.entity.ext.ExtBlockEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class ExtBlockRepositoryTest {

    @Autowired
    private ExtBlockRepository extBlockRepository;

    @DisplayName("select 테스트")
    @Test
    public void select(){
        ExtBlockRequestDto dto = ExtBlockRequestDto.builder()
                .ext("테스트")
                .build();

        ExtBlockEntity extBlockEntity1 = extBlockRepository.save(ExtBlockEntity.of(dto));
        ExtBlockEntity extBlockEntity2 = extBlockRepository.findAll().get(0);

        Assertions.assertThat(extBlockEntity1).isEqualTo(extBlockEntity2);
    }

    @DisplayName("insert 테스트")
    @Test
    public void insert(){
        ExtBlockRequestDto dto = ExtBlockRequestDto.builder()
                .ext("테스트")
                .build();

        extBlockRepository.save(ExtBlockEntity.of(dto));

        Assertions.assertThat(1).isEqualTo(extBlockRepository.count());
    }

   @DisplayName("update 테스트")
   @Test
   public void update(){
       ExtBlockRequestDto dto = ExtBlockRequestDto.builder()
               .ext("old")
               .build();

       ExtBlockEntity extBlockEntity = extBlockRepository.save(ExtBlockEntity.of(dto));
       Assertions.assertThat(extBlockEntity.getExt()).isEqualTo("old");

       extBlockEntity.updateByExt("new");
       Assertions.assertThat(extBlockEntity.getExt()).isEqualTo("new");
   }

   @DisplayName("delete 테스트")
   @Test
   public void delete(){
       ExtBlockRequestDto dto = ExtBlockRequestDto.builder()
               .ext("테스트")
               .build();

       ExtBlockEntity extBlockEntity = extBlockRepository.save(ExtBlockEntity.of(dto));
       Assertions.assertThat(1).isEqualTo(extBlockRepository.count());

       extBlockRepository.deleteById(extBlockEntity.getId());
       Assertions.assertThat(0).isEqualTo(extBlockRepository.count());

   }


}