package aa_A_KeyConcepts.g.InputOutputEnumeration.Enumeration;

import java.util.Scanner;

public class YourWeight {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your weight on earth: ");
		double earthWeight = scan.nextDouble();
		scan.close();
		
		double mass = earthWeight / Planet.EARTH.surfaceGravity();
		for (Planet p : Planet.values()) {
			System.out.printf("Your weight on %s is %f%n", p, mass * p.surfaceGravity());
		}

	}

}
