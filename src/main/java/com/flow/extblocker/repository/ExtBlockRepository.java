package com.flow.extblocker.repository;

import com.flow.extblocker.entity.ext.ExtBlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ExtBlockRepository extends JpaRepository<ExtBlockEntity, Long> {
}
