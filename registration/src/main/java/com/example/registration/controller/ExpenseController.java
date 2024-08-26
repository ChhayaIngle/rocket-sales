package com.example.registration.controller;

import com.example.registration.entity.Expense;
import com.example.registration.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id)
                .map(expense -> ResponseEntity.ok().body(expense))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Expense createExpense(@RequestParam String employeeName,
                                 @RequestParam String expenseType,
                                 @RequestParam String expenseDescription,
                                 @RequestParam Double amount,
                                 @RequestParam String date,
                                 @RequestParam("uploadBill") MultipartFile file) throws IOException, ParseException {

        return expenseService.createExpense(employeeName, expenseType, expenseDescription, amount, date, file);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id,
                                                 @RequestParam String employeeName,
                                                 @RequestParam String expenseType,
                                                 @RequestParam String expenseDescription,
                                                 @RequestParam Double amount,
                                                 @RequestParam String date,
                                                 @RequestParam("uploadBill") MultipartFile file) throws IOException, ParseException {

        return expenseService.updateExpense(id, employeeName, expenseType, expenseDescription, amount, date, file)
                .map(updatedExpense -> ResponseEntity.ok().body(updatedExpense))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok().build();
    }
}
