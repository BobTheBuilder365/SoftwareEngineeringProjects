package k05_InheritanceAndClassHierarchies.Banking.AbstractModel;

import java.util.Date;

abstract public class FinanceProduct implements Comparable {
	
	private String name;
	private final int ID = 0;
	private Date begin = null;
	private Date end = null;
	private double value = 0;
	private double interestRate = 0;
	

}
