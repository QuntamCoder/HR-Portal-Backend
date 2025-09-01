-- Insert Roles
INSERT INTO roles (name) VALUES
('Admin'),
('Employee');

-- Insert Departments
INSERT INTO department (name, description, head_id) VALUES
('Human Resources', 'Handles recruitment, payroll, and employee relations.', NULL),
('Finance', 'Manages company finances and payroll.', NULL),
('Engineering', 'Responsible for product development.', NULL);

-- Insert Teams
INSERT INTO team (name, description, lead_id) VALUES
('Backend Team', 'Handles server-side logic', NULL),
('Frontend Team', 'Handles UI/UX', NULL),
('QA Team', 'Responsible for testing', NULL);

-- Insert Employees (at least a few to reference for head_id, lead_id, manager_id, etc.)
INSERT INTO employee (first_name, middle_name, last_name, dob, gender, email, phone, address, national_id, passport_number, marital_status, emergency_contact_name, emergency_contact_phone, hire_date, department_id, team_id, position, employment_type, status, photo_url, notes)
VALUES
('Rohit', 'Kumar', 'Sharma', '1985-04-15', 'Male', 'rohit.sharma@example.com', '9876543210', 'B-12, Connaught Place, New Delhi', 'AANPS1234L', 'N1234567', 'Married', 'Priya Sharma', '9999988888', '2010-06-01', 1, 1, 'HR Manager', 'Full-time', 'Active', NULL, 'Excellent leader'),
('Sneha', 'Rani', 'Patil', '1990-11-22', 'Female', 'sneha.patil@example.com', '9123456789', 'Flat 402, Kalyani Nagar, Pune', 'BPLPS5678Q', 'N8765432', 'Single', 'Rahul Patil', '8888877777', '2015-08-15', 2, 2, 'Accountant', 'Full-time', 'Active', NULL, ''),
('Amit', '', 'Verma', '1992-02-10', 'Male', 'amit.verma@example.com', '9988776655', 'Plot 21, Anna Nagar, Chennai', 'CPQPV9876K', 'N2345678', 'Married', 'Sunita Verma', '7777766666', '2016-09-12', 3, 3, 'Software Engineer', 'Full-time', 'Active', NULL, ''),
('Pooja', '', 'Singh', '1988-07-18', 'Female', 'pooja.singh@example.com', '8899776655', 'A-44, Salt Lake, Kolkata', 'DPQPS1234T', 'N3456789', 'Single', 'Kiran Singh', '6666655555', '2018-03-20', 1, 2, 'Recruiter', 'Full-time', 'Active', NULL, '');

-- Update Departments and Teams with head_id/lead_id (use existing employee ids, typically starting from 1)
UPDATE department SET head_id = 1 WHERE id = 1;
UPDATE department SET head_id = 2 WHERE id = 2;
UPDATE department SET head_id = 3 WHERE id = 3;

UPDATE team SET lead_id = 3 WHERE id = 1;
UPDATE team  SET lead_id = 4 WHERE id = 2;
UPDATE team SET lead_id = 1 WHERE id = 3;
select  * from role;
-- Insert Users
INSERT INTO user (username, password_hash, email, role_id, employee_id) VALUES
('rohitsharma', 'hashed_password_1', 'rohit.sharma@example.com', 2, 1),
('snehapatil', 'hashed_password_2', 'sneha.patil@example.com', 1, 2);

-- Insert Attendance
INSERT INTO attendance (employee_id, date, check_in, check_out, worked_hours, is_late, status, remarks) VALUES
(1, '2025-08-30', '09:10:00', '18:15:00', 8.92, false, 'Present', ''),
(2, '2025-08-30', '09:45:00', '18:20:00', 8.58, true, 'Present', 'Late by 15 min'),
(3, '2025-08-30', '09:05:00', '18:10:00', 8.92, false, 'Present', ''),
(4, '2025-08-30', '09:00:00', '18:00:00', 9.00, false, 'Present', '');

-- Insert Payroll
INSERT INTO payroll (employee_id, pay_period_start, pay_period_end, basic_salary, deductions, bonuses, taxes, net_pay, bank_account_number, payment_method, payroll_status, paid_on) VALUES
(1, '2025-08-01', '2025-08-31', 90000, 5000, 2500, 8000, 84500, 'SBIN000123456', 'Bank Transfer', 'Paid', '2025-09-01'),
(2, '2025-08-01', '2025-08-31', 60000, 2000, 1000, 4500, 54500, 'HDFC000987654', 'Bank Transfer', 'Paid', '2025-09-01');

-- Insert Leave Types
INSERT INTO leave_type (name, description) VALUES
('Sick Leave', 'Leave for medical reasons'),
('Casual Leave', 'General purpose leave'),
('Earned Leave', 'Earned for long service');

-- Insert Leaves
INSERT INTO leaves (employee_id, leave_type_id, start_date, end_date, leave_days, reason, document_url, status, applied_on, approved_by, rejection_reason) VALUES
(2, 1, '2025-08-10', '2025-08-12', 3, 'Fever and cold', NULL, 'Approved', '2025-08-08', 1, NULL),
(3, 2, '2025-08-15', '2025-08-15', 1, 'Family function', NULL, 'Approved', '2025-08-10', 2, NULL);

-- Insert Performance Reviews
INSERT INTO performance_review (employee_id, reviewer_id, review_date, review_period, score, overall_rating, goals, improvement_plan, comments) VALUES
(3, 1, '2025-08-20', '2025 Q2', 90, 'Excellent', 'Lead a new project', 'Improve communication', 'Great job overall'),
(2, 1, '2025-08-21', '2025 Q2', 78, 'Good', 'Complete cost analysis', 'Time management', 'Solid performance');

-- Insert Notices
INSERT INTO notice (title, content, posted_by) VALUES
('Ganesh Chaturthi Holiday', 'Office will remain closed on 7th September for Ganesh Chaturthi.', 1),
('Annual Sports Day', 'Annual Sports Day will be held on 16th September, all are requested to participate.', 3);