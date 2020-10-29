package aa_A_KeyConcepts.h.Datenstrukturen.JavaFXCollections;

// Example 5 Using ObservableMap
/*
 * You can listen for changes on an ObservableMap in a similar manner, as shown in Example 5.
 */

import java.util.Map;
import java.util.HashMap;
import javafx.collections.ObservableMap;
import javafx.collections.MapChangeListener;
import javafx.collections.FXCollections;

public class FXCollectionsDemoUsingAObservableMap {

	public static void main(String[] args) {
		// Use Java Collections to create the List.
		Map<String, String> map = new HashMap<String, String>();

		// Now add observability by wrapping it with ObservableList.
		ObservableMap<String, String> observableMap = FXCollections.observableMap(map);
		observableMap.addListener(new MapChangeListener() {
			@Override
			public void onChanged(MapChangeListener.Change change) {
				System.out.println("Detected a change! ");
			}
		});

		// Changes to the observableMap WILL be reported.
		observableMap.put("key 1", "value 1");
		System.out.println("Size: " + observableMap.size());

		// Changes to the underlying map will NOT be reported.
		map.put("key 2", "value 2");
		System.out.println("Size: " + observableMap.size());

	}
}
