package k05_InheritanceAndClassHierarchies.Webshop;

public class Sculpture extends Product {

	public enum Materials {
		WOOD, CLAY, BRONZE,
		
		@Override
		public String toString() {
			 String str = Materials.valueOf
		}
	}

	public enum Unique {
		Unique, NotUnique
	}
	
	public final Unique unique;
	public Materials materials;

	protected Sculpture(double value, String name, Unique unique, Materials materials) {
		super(value, name);
		this.unique= unique;
		this.materials = materials;
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
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

}
