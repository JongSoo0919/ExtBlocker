package com.flow.extblocker.entity.ext;

import com.flow.extblocker.controller.dto.request.ExtBlockRequestDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "ext_blocks", indexes = {
        @Index(columnList = "ext")
})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
@EntityListeners(AuditingEntityListener.class)
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
