package aa_Interfaces;

public interface Area {
	
	public abstract double getLength();
	public abstract double getWidth();
	
	public static double computeArea(Area a) {
		return a.getLength() * a.getWidth();
	}

}
