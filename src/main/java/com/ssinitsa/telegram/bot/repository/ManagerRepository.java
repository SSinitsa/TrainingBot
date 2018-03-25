package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager, Long> {
}
