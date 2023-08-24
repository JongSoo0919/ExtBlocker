package com.flow.extblocker.entity.ext;

import com.flow.extblocker.dto.request.ExtBlockRequestDto;
import com.flow.extblocker.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "ext_blocks", indexes = {
        @Index(columnList = "ext")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class ExtBlockEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ext", unique = true, nullable = false)
    private String ext;

    @Builder
    private ExtBlockEntity(String ext) {
        this.ext = ext;
    }

    public void updateByExt(String ext){
        this.ext = ext;
    }

    public static ExtBlockEntity of(ExtBlockRequestDto dto){
        return ExtBlockEntity.builder()
                .ext(dto.getExt())
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExtBlockEntity that = (ExtBlockEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
