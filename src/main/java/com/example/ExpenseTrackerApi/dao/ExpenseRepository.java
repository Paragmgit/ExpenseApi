package com.example.ExpenseTrackerApi.dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ExpenseTrackerApi.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Integer>{
	
	@Query(value = "SELECT * FROM expense_tbl WHERE date =:date", nativeQuery = true)
	List<Expense> findByDate(@Param("date")Date date);

}
