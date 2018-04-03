package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.Materials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialsRepository extends JpaRepository<Materials, Long> {

    Materials findByTitle (String title);

}
