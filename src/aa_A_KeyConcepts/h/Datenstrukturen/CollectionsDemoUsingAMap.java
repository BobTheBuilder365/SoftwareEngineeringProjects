package aa_A_KeyConcepts.h.Datenstrukturen;

import java.util.HashMap;
import java.util.Map;

// Example 2 Using a Map
/*
 * A Map is an object that maps keys to values. A Map can not contain duplicate keys; each key can map to only one value. You can put keys and values into a Map, then retrieve a value by passing in its key. For example, the key apple might return fruit, whereas carrot might return vegetable.
 * Example 2 demonstrates these methods with a Map of String objects:
 */
/*
 * This program first instantiates a HashMap (a concrete implementation of the Map interface) and assigns it to the map variable. Key-value pairs are then added to map by invoking its put method. The program then obtains (and prints out) some information about the map by invoking size() and isEmpty(). The program also demonstrates how to obtain the value for a given key (for example, map.get("apple") returns the value fruit). The containsKey and containsValue methods demonstrate how to test if a particular key or value is present, and the clear method removes all of the key-value mappings.
 */
public class CollectionsDemoUsingAMap {

	public static void main(String[] args) {
		// Create a Map.
		Map<String, String> map = new HashMap<String, String>();
		map.put("apple", "fruit");
		map.put("carrot", "vegetable");
		System.out.println("Size: " + map.size());
		System.out.println("Empty? " + map.isEmpty());

		// Pass in keys; print out values.
		System.out.println("Passing in keys and printing out values...");
		System.out.println("Key is apple, value is: " + map.get("apple"));
		System.out.println("Key is carrot, value is: " + map.get("carrot"));
		System.out.println("");

		// Check keys and values.
		System.out.println("Inspecting keys and values:");
		System.out.println("Contains key \"apple\"? " + map.containsKey("apple"));
		System.out.println("Contains key \"carrot\"? " + map.containsKey("carrot"));
		System.out.println("Contains key \"fruit\"? " + map.containsKey("fruit"));
		System.out.println("Contains key \"vegetable\"? " + map.containsKey("vegetable"));
		System.out.println("Contains value \"apple\"? " + map.containsValue("apple"));
		System.out.println("Contains value \"carrot\"? " + map.containsValue("carrot"));
		System.out.println("Contains value \"fruit\"? " + map.containsValue("fruit"));
		System.out.println("Contains value \"vegetable\"? " + map.containsValue("vegetable"));
		System.out.println("");

		// Remove objects from the map.
		System.out.println("Removing apple from the map...");
		map.remove("apple");
		System.out.println("Size: " + map.size());
		System.out.println("Contains key \"apple\"? " + map.containsKey("apple"));
		System.out.println("Invoking map.clear()...");
		map.clear();
		System.out.println("Size: " + map.size());
	}

	/**
	 * The output of Example 2 is as follows:
	 * 
	 * Size: 2
	 * 
	 * Empty? false
	 * 
	 * Passing in keys and printing out values...
	 * 
	 * Key is apple, value is: fruit
	 * 
	 * Key is carrot, value is: vegetable
	 * 
	 * Inspecting keys and values:
	 * 
	 * Contains key "apple"? true
	 * 
	 * Contains key "carrot"? true
	 * 
	 * Contains key "fruit"? false
	 * 
	 * Contains key "vegetable"? false
	 * 
	 * Contains value "apple"? false
	 * 
	 * Contains value "carrot"? false
	 * 
	 * Contains value "fruit"? true
	 * 
	 * Contains value "vegetable"? true
	 * 
	 * Removing apple from the map...
	 * 
	 * Size: 1
	 * 
	 * Contains key "apple"? false
	 * 
	 * Invoking map.clear()...
	 * 
	 * Size: 0
	 */
}
