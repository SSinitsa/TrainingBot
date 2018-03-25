package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
