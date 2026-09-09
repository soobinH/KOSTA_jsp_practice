package dto;

import exc.BankException;
import exc.ERR_CODE;

public class Account {
	String id;
	String name;
	String type;
	Integer balance;
	String grade;
	
	public Account() {
		
	}
	
	public Account(String id, String name, int balance, String type, String grade) {
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.type= type;
		this.grade = grade;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getBalance() {
		return balance;
	}
	
	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public void deposit(Integer money)throws BankException{
		if(money <= 0) throw new BankException(ERR_CODE.DEPOSIT);
		balance += money;
	}
	
	public void withdraw(Integer money) throws BankException {
		if(balance < money) throw new BankException(ERR_CODE.WITHDRAW);
		balance -= money; 
	}
	
	public void transfer(int money) {
		balance += money;
	}
	
	@Override
	public String toString() {
		return String.format("계좌번호: %s, 이름: %s, 잔액: %d, 타입: %s, 등급: %s", id, name, balance, type, grade);
	}

	
}
