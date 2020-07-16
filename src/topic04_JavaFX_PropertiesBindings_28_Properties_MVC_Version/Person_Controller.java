package topic04_JavaFX_PropertiesBindings_28_Properties_MVC_Version;

public class Person_Controller {
	
	private final Person_Model model;
	private final Person_View view;
	
	protected Person_Controller(Person_Model model, Person_View view) {
		this.model = model;
		this.view = view;
	}

}
