package com.HR_Management_backend.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity

public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer noticeId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "posted_by")
    private Employee postedBy;

    public Notice() {
    }

    public Notice(Integer noticeId, String title, String content, Date createdAt, Employee postedBy) {
        this.noticeId = noticeId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.postedBy = postedBy;
    }

    public Integer getNoticeId() {
        return noticeId;
    }

    public Notice setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Notice setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getContent() {
        return content;
    }

    public Notice setContent(String content) {
        this.content = content;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Notice setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Employee getPostedBy() {
        return postedBy;
    }

    public Notice setPostedBy(Employee postedBy) {
        this.postedBy = postedBy;
        return this;
    }
}