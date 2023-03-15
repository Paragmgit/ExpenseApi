package com.example.ExpenseTrackerApi.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ExpenseTrackerApi.model.Expense;
import com.example.ExpenseTrackerApi.service.ExpenseService;

@RestController
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@PostMapping(value = "/add-expense")
	public ResponseEntity<Expense> createExpense(@RequestBody Expense expense){
		Expense expense2 = expenseService.addExpense(expense);
		return new ResponseEntity<Expense>(expense2,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/month")
	public ResponseEntity<List<Expense>> totalExpandature(){
	List<Expense>expense =expenseService.totalExpandature();
		return new ResponseEntity<List<Expense>>(expense,HttpStatus.OK);
	}

	@GetMapping(value = "/getId/{expenseId}")
	public ResponseEntity<Expense>getExpenseById(@PathVariable Integer expenseId){
		Expense expense = expenseService.getExpenseById(expenseId);
		return new ResponseEntity<Expense>(expense,HttpStatus.OK);
	}
	
	@GetMapping("/expenses/{date}")
	public ResponseEntity<List<Expense>> getExpensesByDate(@PathVariable Date date) {
	    List<Expense> expenses = expenseService.findByDate(date);
	    return new ResponseEntity<List<Expense>>(expenses,HttpStatus.OK);
	}

	@PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Integer id, @RequestBody Expense expense) {
        Expense updatedExpense = expenseService.updateExpense(id, expense);
        return new ResponseEntity<Expense>(updatedExpense,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Integer id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
