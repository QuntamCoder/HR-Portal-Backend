package com.HR_Management_backend.service;

import com.HR_Management_backend.entity.Notice;
import com.HR_Management_backend.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    public Notice createNotice(Notice notice) {
        notice.setCreatedAt(new Date());
        notice.setPostedBy("admin"); // Force static value
        return noticeRepository.save(notice);
    }

    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    public Notice getNoticeById(Integer id) {
        return noticeRepository.findById(id).orElse(null);
    }

    public void deleteNotice(Integer id) {
        noticeRepository.deleteById(id);
    }
}