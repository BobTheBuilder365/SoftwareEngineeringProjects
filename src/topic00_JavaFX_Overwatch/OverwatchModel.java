package topic00_JavaFX_Overwatch;

public class OverwatchModel {
	
	// ButtonCLick
	private int value;
	public int getValue() {
		return value;
	}
	public int incrementValue() {
		value++;
		return value;
	}	
	
	// Konstruktor
	protected OverwatchModel() {
		
		// ButtonCLick
		value = 0;
	}


}
