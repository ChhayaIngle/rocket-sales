package com.example.registration.service;

import com.example.registration.entity.Expense;
import com.example.registration.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense createExpense(String employeeName, String expenseType, String expenseDescription, 
                                 Double amount, String date, MultipartFile file) throws IOException, ParseException {

        Expense expense = new Expense();
        expense.setEmployee_name(employeeName);
        expense.setExpense_type(expenseType);
        expense.setExpense_description(expenseDescription);
        expense.setAmount(amount);
        expense.setDate(parseDate(date));
        expense.setUpload_bill(file.getBytes());

        return expenseRepository.save(expense);
    }

    public Optional<Expense> updateExpense(Long id, String employeeName, String expenseType, 
                                           String expenseDescription, Double amount, 
                                           String date, MultipartFile file) throws IOException, ParseException {

        return expenseRepository.findById(id)
                .map(expense -> {
                    expense.setEmployee_name(employeeName);
                    expense.setExpense_type(expenseType);
                    expense.setExpense_description(expenseDescription);
                    expense.setAmount(amount);
                    try {
						expense.setDate(parseDate(date));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                    try {
                        expense.setUpload_bill(file.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return expenseRepository.save(expense);
                });
    }

    public void deleteExpense(Long id) {
        expenseRepository.findById(id).ifPresent(expense -> expenseRepository.delete(expense));
    }

    private Date parseDate(String date) throws ParseException {
        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
    }
}
