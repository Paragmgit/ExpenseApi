package com.example.ExpenseTrackerApi.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ExpenseTrackerApi.dao.ExpenseRepository;
import com.example.ExpenseTrackerApi.model.Expense;

@Service
@Transactional
public class ExpenseService {
	
	Queue<Expense> pq = new LinkedList<>();
	
	@Autowired
	ExpenseRepository expenseRepository;

	public Expense addExpense(Expense expense) {
		pq.add(expense);
		return expenseRepository.save(expense);
	}

	public Expense getExpenseById(Integer expenseId) {
		return expenseRepository.findById(expenseId).get();
	}
	
	public List<Expense> findByDate(Date date) {

		return expenseRepository.findByDate(date);
	}

	public Expense updateExpense(Integer id, Expense expense) {
		Expense existingExp = expenseRepository.findById(id).get();
		existingExp.setTitle(expense.getTitle());
		existingExp.setDescription(expense.getDescription());
		existingExp.setPrice(expense.getPrice());
		existingExp.setDate(expense.getDate());
		existingExp.setTime(expense.getTime());
		return expenseRepository.save(existingExp);
	}

	public void deleteExpense(Integer id) {
		expenseRepository.deleteById(id);
	}

	public List<Expense>totalExpandature() {
		List<Expense> list = new ArrayList<>();
		for(Expense expense:pq) {
			list.add(expense);
			if(list.size()>90 || list.size()>=pq.size()) {
				return list;
			}
		}
		return null;
	}


}
