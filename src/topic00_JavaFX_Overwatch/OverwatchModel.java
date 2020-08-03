package topic00_JavaFX_Overwatch;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import topic06_IO_Lists_Tables_tableViewExampleEDITABLE.SuperNumber;

// Stufe 0 = Basis MVC Struktur und die View

public class OverwatchModel {
	
	// ButtonCLick value
	private int value;
	public int getValue() {
		return value;}
	public int incrementValue() {
		value++;
		return value;}
	
	// EventHandling value
	private int valueEH;
	public int getValueEH() {
		return valueEH;
	}
	public int incrementValueEH() {
		valueEH++;
		return valueEH;
	}
	
	// List View
	// Just Add, multiplybyTwo and getter
	private final ObservableList<Integer> elementsInteger = FXCollections.observableArrayList();
	public void addNewElement() {
		elementsInteger.add(elementsInteger.size());
	}
	public int multiplyByTwo(int input) {
		return input * 2;
	}
		// getters and setters
	public ObservableList<Integer> getIntegerElements() {
		return elementsInteger;
	}	
	
	// Editable TableView
//	private final ObservableList<SuperNumber> elements = FXCollections.observableArrayList();
//	public void addNewElement() {
//		elements.add(new SuperNumber(elements.size()));
//	} // getters and setters
//	public ObservableList<SuperNumber> getElements() {
//		return elements;
//	}	
	
	// 0 Konstruktor
	protected OverwatchModel() {
		
		// ButtonCLick
		value = 0;
		
		// EventHandling
		valueEH = 0;
	}

	// Calculator calculate
	protected String calculate(String in) {
	    boolean error = false;
	    String result;
	    
	    // '+' must be escaped in the regex, using '\'
	    // '\' must be escaped in a String, against using '\'	    
		String[] strValues = in.split("\\+");
		
		// Convert Strings to ints - catch any errors
		int[] intValues = new int[strValues.length];
		try { // parseInt may produce an exception
    		for (int i = 0; i < strValues.length; i++) {
    		    intValues[i] = Integer.parseInt(strValues[i]);
    		}
		} catch (NumberFormatException e) {
		    error = true;
		}
		
		// If error, set result
		// If no error, sum all values and set result 
		if (error) {
		    result = "Error";
		} else {
		    int sum = 0;
		    for (int intValue : intValues) sum += intValue;
		    result = Integer.toString(sum);
		}
		
		return result;
	}
	
	// Dice
	public int getRandomValue() {
		return (int) (Math.random() * 6 + 1);
	}
}
