package k05_InheritanceAndClassHierarchies.Webshop;

public class Webshop_Controller {
	
	// 0 Controller muss Model und View kennen
	private Webshop_Model model;
	private Webshop_View view;
	
	//0 Konstruktor
	public Webshop_Controller(Webshop_Model model, Webshop_View view) {
		this.model = model;
		this.view = view;
		
	}

}
