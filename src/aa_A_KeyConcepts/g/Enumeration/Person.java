package aa_A_KeyConcepts.g.Enumeration;

import aa_A_KeyConcepts.g.Enumeration.EnumerationExample.Gender;

public class Person {
	
	private String name;
	private Gender gender;
	
	public Person(String name, Gender gender) {
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}
	public Gender getGender() {
		return this.gender;
	}

}
