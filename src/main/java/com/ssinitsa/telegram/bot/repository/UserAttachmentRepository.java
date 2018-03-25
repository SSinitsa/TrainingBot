package com.ssinitsa.telegram.bot.repository;

import com.ssinitsa.telegram.bot.entity.UserAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAttachmentRepository extends JpaRepository<UserAttachment, Long> {
}
