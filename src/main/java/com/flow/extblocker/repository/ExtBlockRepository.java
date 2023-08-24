package com.flow.extblocker.repository;

import com.flow.extblocker.entity.ext.ExtBlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ExtBlockRepository extends JpaRepository<ExtBlockEntity, Long> {
    public Optional<ExtBlockEntity> findByExt(String ext);
}
