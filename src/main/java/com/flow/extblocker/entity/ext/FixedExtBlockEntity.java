package com.flow.extblocker.entity.ext;

import com.flow.extblocker.controller.dto.request.FixedExtBlockRequestDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "fixed_ext_blocks")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
public class FixedExtBlockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ext", unique = true, nullable = false)
    private String ext;
    @Column(name = "use_yn")
    private String useYn;
    @CreatedDate
    @Column(name = "reg_date")
    private LocalDateTime regDate;
    @LastModifiedDate
    @Column(name = "mod_date")
    private LocalDateTime modDate;

    public void updateByUseYn(String useYn){
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
