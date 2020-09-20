package k05_InheritanceAndClassHierarchies.Webshop;

import java.util.ArrayList;

public class WebshopTest {
	
	private Sculpture sculpture;
	private Painting painting;
	
	public static void main(String[] args) {
		
		ArrayList<Product> productList = new ArrayList<Product>();
		
		Sculpture sculpture1 = new Sculpture(100.00, "Karl", null, null);
		
		System.out.println(sculpture1);
	}

}
