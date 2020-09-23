package aa_A_KeyConcepts.c.PropertyChangeListenerBinding.VIEW.EmailValidator;

public class EmailValidator_Controller {
	final private EmailValidator_Model model;
	final private EmailValidator_View view;

	protected EmailValidator_Controller(EmailValidator_Model model, EmailValidator_View view) {
		this.model = model;
		this.view = view;

		view.txtEmail.textProperty().addListener(
				// Parameters of any PropertyChangeListener
				(observable, oldValue, newValue) -> validateEmailAddress(newValue));
	}

	private void validateEmailAddress(String newValue) {
		boolean valid = false;

		// Split on '@': must give us two not-empty parts
		String[] addressParts = newValue.split("@");
		if (addressParts.length == 2 && !addressParts[0].isEmpty() && !addressParts[1].isEmpty()) {
			// We want to split the domain on '.', but split does not give us an empty
			// string, if the split-character is the last character in the string. So we
			// first ensure that the string does not end with '.'
			if (addressParts[1].charAt(addressParts[1].length() - 1) != '.') {
				// Split domain on '.': must give us at least two parts.
				// Each part must be at least two characters long
				String[] domainParts = addressParts[1].split("\\.");
				if (domainParts.length >= 2) {
					valid = true;
					for (String s : domainParts) {
						if (s.length() < 2) valid = false;
					}
				}
			}
		}

		view.txtEmail.getStyleClass().remove("emailNotOk");
		view.txtEmail.getStyleClass().remove("emailOk");
		if (valid) {
			view.txtEmail.getStyleClass().add("emailOk");
		} else {
			view.txtEmail.getStyleClass().add("emailNotOk");
		}
	}
}
