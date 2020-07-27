package topic02_JavaFX_Events.eventHandlingSyntax;

public class EventHandlingDemoModel {
	private int value;
	
	protected EventHandlingDemoModel() {
		value = 0;
	}
	
	public int getValue() {
		return value;
	}
	
	public int incrementValue() {
		value++;
		return value;
	}
}
