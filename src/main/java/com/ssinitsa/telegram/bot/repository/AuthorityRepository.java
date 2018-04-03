package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
