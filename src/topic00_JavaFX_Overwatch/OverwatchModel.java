package topic00_JavaFX_Overwatch;

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
