package com.HR_Management_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;

@RestController
public class DbStatusController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/db-status")
    public String checkDbConnection() {
        try (Connection conn = dataSource.getConnection()) {
            if (!conn.isClosed()) {
                return "Database connection established";
            } else {
                return "Database connection failed";
            }
        } catch (Exception e) {
            return "Database connection failed: " + e.getMessage();
        }
    }
}