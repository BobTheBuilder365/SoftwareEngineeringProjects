package k05_InheritanceAndClassHierarchies.Webshop;

public class Painting extends Product {

	public static int globalPaintingID = 0;
	
	public enum PaintingColor { Water, Oil}
	public enum PaintingTyp { Original, Print}

	public Painting(double value, String name) {
		super(value, name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

}
