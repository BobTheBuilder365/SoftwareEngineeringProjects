package topic04_JavaFX_PropertiesBindings_28_Properties_MVC_Version;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person_Model {
	
	// 1. referenziert auf das Objekt
	private StringProperty firstName = new SimpleStringProperty(this, "firstName","");
	
	// Returns the StringProperty object
	public StringProperty getFirstNameProperty() {
		return this.firstName;
	}
	
	// Return the firstName value (ie. "Lisa")
	public String getFirstName() {
		return firstName.get();
	}
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

}
