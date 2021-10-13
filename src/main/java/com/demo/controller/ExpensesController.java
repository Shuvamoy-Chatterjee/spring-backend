package com.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.ResourceNotFoundException;
import com.demo.model.Expenses;
import com.demo.repository.ExpensesRepository;
@CrossOrigin(origins = "https://ng-frontend.azurewebsites.net/")
@RestController
@RequestMapping("/api/")
public class ExpensesController {
	
	@Autowired
	private ExpensesRepository expensesrepository;
	
	//get all expenses list
	@GetMapping("/expenses")
	public List<Expenses> getAllExpenses(){
		return expensesrepository.findAll();
	}
	
	// create expense rest api
		@PostMapping("/expenses")
		public Expenses createEmployee(@RequestBody Expenses expenses) {
			
			return expensesrepository.save(expenses);
		}
		// get employee by id rest api
		@GetMapping("/expenses/{id}")
		public ResponseEntity<Expenses> getExpenseById(@PathVariable Long id) {
			Expenses expense = expensesrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist"));
			return ResponseEntity.ok(expense);
		}
		
		// delete employee rest api
		@DeleteMapping("/expenses/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteExpense(@PathVariable Long id){
			Expenses expense = expensesrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee does not exist"));
			expensesrepository.delete(expense);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
