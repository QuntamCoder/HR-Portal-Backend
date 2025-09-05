package com.HR_Management_backend.service;

import com.HR_Management_backend.entity.Notice;
import com.HR_Management_backend.entity.Employee;
import com.HR_Management_backend.repository.NoticeRepository;
import com.HR_Management_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Notice createNotice(String title, String content, String username) {
        Employee postedBy = employeeRepository.findByEmail(username)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
        Notice notice = new Notice();
        notice.setTitle(title);
        notice.setContent(content);
        notice.setCreatedAt(new Date());
        notice.setPostedBy(postedBy);
        return noticeRepository.save(notice);
    }

    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }
}