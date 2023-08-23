package com.flow.extblocker.entity.ext;

import com.flow.extblocker.controller.dto.ExtBlockDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "ext_blocks")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ExtBlockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ext", unique = true, nullable = false)
    private String ext;
    @CreatedDate
    @Column(name = "reg_date")
    private LocalDateTime regDate;
    @LastModifiedDate
    @Column(name = "mod_date")
    private LocalDateTime modDate;

    @Builder
    public ExtBlockEntity(String ext) {
        this.ext = ext;
    }

    public void updateByExt(String ext){
        this.ext = ext;
    }

    public static ExtBlockEntity of(ExtBlockDto dto){
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
