package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.MaterialsGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialsGroupRepository extends JpaRepository<MaterialsGroup, Long> {
}
