package com.flow.extblocker.entity.ext;

import com.flow.extblocker.dto.request.FixedExtBlockRequestDto;
import com.flow.extblocker.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "fixed_ext_blocks",indexes = {
        @Index(columnList = "ext")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class FixedExtBlockEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ext", unique = true, nullable = false)
    private String ext;
    @Column
    private String useYn;

    public void update(String ext, String useYn){
        this.ext = ext;
        this.useYn = useYn;
    }

    @Builder
    private FixedExtBlockEntity(String ext, String useYn) {
        this.ext = ext;
        this.useYn = useYn;
    }

    public static FixedExtBlockEntity of(FixedExtBlockRequestDto dto){
        return FixedExtBlockEntity.builder()
                .ext(dto.getExt())
                .useYn(dto.getUseYn())
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixedExtBlockEntity that = (FixedExtBlockEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
