package com.HR_Management_backend.controller;

import com.HR_Management_backend.entity.Notice;
import com.HR_Management_backend.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/notices")
@CrossOrigin
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // Create a notice using logged-in employee
    @PostMapping
    public Notice createNotice(@RequestBody Map<String, Object> req, Principal principal) {
        String title = (String) req.get("title");
        String content = (String) req.get("content");
        String username = principal.getName(); // Spring Security username (usually email)
        return noticeService.createNotice(title, content, username);
    }

    // Get all notices
    @GetMapping
    public List<Notice> getAllNotices() {
        return noticeService.getAllNotices();
    }
}