package com.example.ITFB_HW16_2;

import com.example.ITFB_HW16_2.PassportRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Service
public class PassportValidationService {

    public boolean validate(PassportRequest request) {
        try {
            // проверка departmentCode на null и длину
            String deptCode = request.getDepartmentCode();
            if (deptCode == null || deptCode.replaceAll("-", "").length() < 3) return false;
            deptCode = deptCode.replaceAll("-", "");

            char thirdDigit = deptCode.charAt(2);
            if (thirdDigit < '0' || thirdDigit > '3') return false;

            // парсинг дат с проверкой на null
            LocalDate birthDate = null;
            LocalDate issueDate = null;

            try {
                birthDate = LocalDate.parse(request.getBirthDate());
                issueDate = LocalDate.parse(request.getIssueDate());
            } catch (DateTimeParseException e) {
                return false;
            }

            // дата issueDate не раньше 14 лет после birthDate
            if (issueDate.isBefore(birthDate.plusYears(14))) return false;

            // проверка series на null и длину
            String series = request.getPassportSeries();
            if (series == null || series.length() < 2) return false;

            int lastTwo = Integer.parseInt(series.substring(series.length() - 2));
            boolean isValidYear = (lastTwo >= 91 && lastTwo <= 99) || (lastTwo >= 0 && lastTwo <= 25);
            return isValidYear;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
