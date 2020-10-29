package topic_09_Generics.bottle;

// Typenparameter D wird �berall dort verwendet, wo wir wissen m�ssen, was die Flasche f�r einen Inhalt hat
// D ist nur wie eine Variable f�r einen Typ
// D�rfen die Variable nnen wir wir wollen
// Typischerweise nur mit einem Buchstaben, k�nnten anstat D aber auch <Flascheninhalt> bezeichnen

public class Bottle<D> { // TypenParameter D f�r Drink

	private D content; // Inhalt der Flasche

	// brauchen default Konstruktor

	// Flasche f�llen
	public void fill(D content) { // Inhalt vom Typ D f�llen wir die Flasche
		this.content = content; // speichern den neunen Inhalt in die Flasche
	}

	// Flasche leeren (Wenn wir die Flache leeren erhalten wir den Inhalt zur�ck)
	public D empty() {
		D content = this.content;// Nehmen den Inhalt aus der FLasche raus�
		this.content = null;
		return content;
	}
}
