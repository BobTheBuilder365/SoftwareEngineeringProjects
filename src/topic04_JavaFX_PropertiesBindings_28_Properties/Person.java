package topic04_JavaFX_PropertiesBindings_28_Properties;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	
	private StringProperty firstName = new SimpleStringProperty(this, "fistName", "");

	// Returns the StringProperty object (Returns the object itself)
	// We need that object when we add a Listener to it
	public StringProperty firstNameProperty() {
		return firstName;
	}
	
	// Return the firstName value (ie. "Lisa") (GETTER)
	public String getFirstName() {
		return this.firstName.get();
	}
	// Set the firstName vlaue (SETTER)
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}
}
