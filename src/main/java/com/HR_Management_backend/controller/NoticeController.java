package com.HR_Management_backend.controller;

import com.HR_Management_backend.entity.Notice;
import com.HR_Management_backend.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping
    public Notice createNotice(@RequestBody Notice notice) {
        return noticeService.createNotice(notice);
    }

    @GetMapping
    public List<Notice> getAllNotices() {
        return noticeService.getAllNotices();
    }

    @GetMapping("/{id}")
    public Notice getNoticeById(@PathVariable Integer id) {
        return noticeService.getNoticeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteNotice(@PathVariable Integer id) {
        noticeService.deleteNotice(id);
    }
}