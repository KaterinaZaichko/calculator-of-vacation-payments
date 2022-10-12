package controllers;

import models.Calculator;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class CalculatorController {
    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "averageSalary", required = false) Double averageSalary,
                            @RequestParam(value = "startDateOfVacation", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDateOfVacation,
                            @RequestParam(value = "endDateOfVacation", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDateOfVacation,
                            Model model) {
        Calculator calculator = new Calculator();
        String result = "0";
        if(averageSalary != null && startDateOfVacation != null && endDateOfVacation != null) {
            calculator.setAverageSalary(averageSalary);
            calculator.setStartDateOfVacation(startDateOfVacation);
            calculator.setEndDateOfVacation(endDateOfVacation);
            result = calculator.getVacationPayments();
        }
        model.addAttribute("vacationPayments", result);
        return "calculate";
    }
}
