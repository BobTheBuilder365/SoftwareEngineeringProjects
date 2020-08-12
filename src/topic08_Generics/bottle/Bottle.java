package topic08_Generics.bottle;

// Typenparameter D wird überall dort verwendet, wo wir wissen müssen, was die Flasche für einen Inhalt hat
// D ist nur wie eine Variable für einen Typ
// Dürfen die Variable nnen wir wir wollen
// Typischerweise nur mit einem Buchstaben, könnten anstat D aber auch <Flascheninhalt> bezeichnen

public class Bottle<D> { // TypenParameter D für Drink
	
	private D content; // Inhalt der Flasche
	
	// brauchen default Konstruktor
	
	// Flasche füllen
	public void fill(D content) { // Inhalt vom Typ D füllen wir die Flasche
		this.content = content; // speichern den neunen Inhalt in die Flasche
	}

	// Flasche leeren (Wenn wir die Flache leeren erhalten wir den Inhalt zurück)
	public D empty() {
		D content = this.content;// Nehmen den Inhalt aus der FLasche raus¨
		this.content = null;
		return content;
	}
}
