package com.HR_Management_backend.repository;

import com.HR_Management_backend.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
    // Optionally, add methods like findByPostedBy, findByTitleContaining, etc.
}