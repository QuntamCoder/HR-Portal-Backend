package com.HR_Management_backend.service;

import com.HR_Management_backend.entity.*;
import com.HR_Management_backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private AttendanceRepository attendanceRepository;

    // Auto-generate payroll for employee & period
    public Payroll generatePayroll(Integer employeeId, Date payPeriodStart, Date payPeriodEnd) {
        Salary salary = salaryRepository.findByEmployeeId(employeeId)
                .orElseThrow(() -> new RuntimeException("Salary info not found!"));

        List<Attendance> attendanceList = attendanceRepository.findByEmployeeIdAndDateBetween(employeeId, payPeriodStart, payPeriodEnd);

        long presentDays = attendanceList.stream()
                .filter(a -> "present".equalsIgnoreCase(a.getStatus()))
                .count();

        double perDaySalary = salary.getBasicSalary() / 30.0;
        double grossPay = perDaySalary * presentDays;
        double netPay = grossPay; // extend logic if you want deductions/tax

        Payroll payroll = new Payroll();
        payroll.setEmployee(salary.getEmployee());
        payroll.setPayPeriodStart(payPeriodStart);
        payroll.setPayPeriodEnd(payPeriodEnd);
        payroll.setPresentDays((int)presentDays);
        payroll.setBasicSalary(salary.getBasicSalary());
        payroll.setGrossPay(grossPay);
        payroll.setNetPay(netPay);
        payroll.setPayrollStatus("Pending");
        payroll.setPaidOn(null);

        return payrollRepository.save(payroll);
    }

    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    public List<Payroll> getPayrollsByEmployeeId(Integer employeeId) {
        return payrollRepository.findByEmployeeId(employeeId);
    }

    public Optional<Payroll> getPayrollById(Integer id) {
        return payrollRepository.findById(id);
    }

    // Generate Salary Slip PDF for a Payroll record
    public byte[] generateSalarySlipPdf(Payroll payroll) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);

        PDPageContentStream contentStream = new PDPageContentStream(document, page);

        contentStream.setFont(PDType1Font.HELVETICA_BOLD, 18);
        contentStream.beginText();
        contentStream.newLineAtOffset(220, 750);
        contentStream.showText("Salary Slip");
        contentStream.endText();

        contentStream.setFont(PDType1Font.HELVETICA, 12);
        int y = 710;
        int lineHeight = 22;

        contentStream.beginText();
        contentStream.newLineAtOffset(70, y);
        contentStream.showText("Employee: " + payroll.getEmployee().getFirstName() + " " + payroll.getEmployee().getLastName());
        contentStream.endText();

        y -= lineHeight;
        contentStream.beginText();
        contentStream.newLineAtOffset(70, y);
        contentStream.showText("Pay Period: " + payroll.getPayPeriodStart() + " to " + payroll.getPayPeriodEnd());
        contentStream.endText();

        y -= lineHeight;
        contentStream.beginText();
        contentStream.newLineAtOffset(70, y);
        contentStream.showText("Present Days: " + payroll.getPresentDays());
        contentStream.endText();

        y -= lineHeight;
        contentStream.beginText();
        contentStream.newLineAtOffset(70, y);
        contentStream.showText("Basic Salary: ₹" + payroll.getBasicSalary());
        contentStream.endText();

        y -= lineHeight;
        contentStream.beginText();
        contentStream.newLineAtOffset(70, y);
        contentStream.showText("Gross Pay: ₹" + payroll.getGrossPay());
        contentStream.endText();

        y -= lineHeight;
        contentStream.beginText();
        contentStream.newLineAtOffset(70, y);
        contentStream.showText("Net Pay: ₹" + payroll.getNetPay());
        contentStream.endText();

        y -= lineHeight;
        contentStream.beginText();
        contentStream.newLineAtOffset(70, y);
        contentStream.showText("Status: " + payroll.getPayrollStatus());
        contentStream.endText();

        contentStream.close();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        document.save(baos);
        document.close();

        return baos.toByteArray();
    }
}