package aa_A_KeyConcepts.g.InputOutputEnumeration.READText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTextFile_Model {

	// Objekt um die Datei zu speichern
	private static String TEXT_FILE_NUMBERS = "numbersAsText.txt";

	// Liste um die Zahlen aus der Datei zu speichern
	private ArrayList<Integer> numbers = null;

	/**
	 * Mit der Methode readFile Lesen wir eine TEXTBASIERTE Datein aus in der Zahlen
	 * enthalten sind Zeile für Zeile aus, und Fuegen die ausgelesenen Zahlen der
	 * ArrayList hinzu
	 */
	public void readFile_v1() {
		InputStream inStream = this.getClass().getResourceAsStream(TEXT_FILE_NUMBERS); // Input Ressource
		String data = "";
		// Ab hier brauchen wir try-catch, verwenden hier "try with Ressources"
		// Wollen vom InputStream lesen, allerdings ist InputStream eine binäre Klasse,
		// wir wissen aber,
		// dass es eine Text Datei ist und pro Zeile ist eine Zahl, deshalb möchten wir
		// hier eine
		// Verkettung verwenden. Möchten kein InputStream sondern eine Reader Klasse.
		/**
		 * Ziel: InputStream lesen um InputStream zu lesen, brauchen wir einen
		 * InputStreamReader da wir Zeile für Zeile auslesen möchten, müssen wir noch
		 * einen BufferedReader davor setzen
		 * 
		 */
		try (BufferedReader fileInput = new BufferedReader(new InputStreamReader(inStream))) {
			// 0. Brauchen Liste
			// 1. Möchte Zeile lesen
			// 1.1 (Schritte machen solange wir Zeilen haben(also line != null) = while
			// Schleife)
			// 2. Möchte Zeile bearbeiten (Aus der Zeile den Text(ist ja Zahl) als Integer
			// Wert speichern
			// 2.2 Den geparsten(analysierten) Wert der ArrayList HINZUFUEGEN
			// 3. Nächste Zeile lesen
			// 4. Nächste Zeile bearbeiten
			numbers = new ArrayList<>(); // 0.
			String line = fileInput.readLine(); // 1.
			while (line != null) { // 1.1
				int number = Integer.parseInt(line); // 2.
				numbers.add(number);// 2.2
				line = fileInput.readLine();// 3.
			}

		} catch (IOException e) {
			// Zum sicherstellen, dass die ArrayListe mit den Nummern noch nicht exisitiert
			numbers = null;
		}

	}

	public void readFile_v2() {
		InputStream inStream = this.getClass().getResourceAsStream(TEXT_FILE_NUMBERS);
		try (Scanner in = new Scanner(inStream)) {
			numbers = new ArrayList<>();
			while (in.hasNext()) {
				int number = in.nextInt();
				numbers.add(number);
			}
		} catch (Exception e) {
			numbers = null;
		}
	}

	public boolean hasNumbers() {
		return (numbers != null);
	}

	public ArrayList<Integer> getNumbers() {
		return numbers;
	}

	public int calculateTotal() {
		int total = 0;
		for (int number : numbers)
			total += number;
		return total;
	}
}
