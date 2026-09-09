package dto;

public class Account{
	String id;
	String name;
	Integer balance;
	String type;
	String grade;
	/**
	 * @param id
	 * @param name
	 * @param balance
	 * @param type
	 * @param grade
	 */
	public Account(String id, String name, Integer balance, String type, String grade) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
		this.type = type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public void deposit(Integer money) {
		balance += money;
	}
	public void withdraw(Integer money) {
		if(balance>=money) {
			balance -= money;
		}
	}
}

