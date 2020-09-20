package k05_InheritanceAndClassHierarchies.Webshop;

import aa_Interfaces.Buyable;
import aa_Interfaces.Nameable;
import aa_Interfaces.Printable;

public abstract class Product implements Buyable, Printable, Nameable {
	
	public static int globalProductID = 0;
	private double value = 0;
	private String name = null;
	
	
	public Product(double value, String name) {
		this.value = value;
		this.name = name;
		globalProductID++;
	}

}
