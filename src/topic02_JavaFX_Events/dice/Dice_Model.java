package topic02_JavaFX_Events.dice;

public class Dice_Model {
	public int getRandomValue() {
		return (int) (Math.random() * 6 + 1);
	}
}
