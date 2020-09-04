package topic_10_JavaAppTemplate.globalResources.singleton;

public class Woof {

	private int x;

	private Woof() {
		x = 0;

	}

	// Factory Methode
	public static Woof makeWoof(int newX) {
		if (newX >= 0) {
			Woof w = new Woof();
			w.x = newX;
			return w;
		} else {
			return null;
		}

	}

}
