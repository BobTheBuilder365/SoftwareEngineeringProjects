package aa_A_KeyConcepts.PlayerCardApp.Model;

public enum Position {
	
	Stürmer, Verteidiger, Torwart;
	
	/**
	 * Überprüft ob searchString in diesem Namen vorkommt
	 */
	public boolean contains(String searchString) {
		return (this.name().contains(searchString));
	}

}
