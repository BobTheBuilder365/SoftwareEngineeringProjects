package k05_InheritanceAndClassHierarchies.Banking.AbstractModel;

import java.util.Date;

abstract public class Account implements Comparable<Object> {
	
	static final int ID = 0;
	
	private String name;
	private Date begin = null;
	private Date end = null;
	private double balance = 0;
	private double interestRate = 0;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public double getValue() {
		return balance;
	}
	public void setValue(double value) {
		this.balance = value;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	public int getID() {
		return ID;
	}
	
	

}
