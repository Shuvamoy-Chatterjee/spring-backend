package com.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Shuvamoy_Expenses")
public class Expenses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "category_name")
	private String Category;
	
	@Column(name = "Authorizer_name")
	private String AuthorizedBy;
	
	@Column(name = "Expense_amount")
	private long ExpenseAmount;
	
	@Column(name = "factory_name")
	private String Factory;

	
	
	public Expenses() {
	}

	public Expenses(String category, String authorizedBy, long expenseAmount, String factory) {
		super();
		Category = category;
		AuthorizedBy = authorizedBy;
		ExpenseAmount = expenseAmount;
		Factory = factory;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public String getAuthorizedBy() {
		return AuthorizedBy;
	}

	public void setAuthorizedBy(String authorizedBy) {
		AuthorizedBy = authorizedBy;
	}

	public long getExpenseAmount() {
		return ExpenseAmount;
	}

	public void setExpenseAmount(long expenseAmount) {
		ExpenseAmount = expenseAmount;
	}

	public String getFactory() {
		return Factory;
	}

	public void setFactory(String factory) {
		Factory = factory;
	}
	
	
	
	
}
