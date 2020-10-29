package aa_A_KeyConcepts.h.Datenstrukturen.JavaFXCollections;

// Example 6 Collections Vs. FXCollections Change Notifications
/*
 * In Example 6, the line FXCollections.sort(obervableList) alphabetically sorts the String objects in the list, and prints only one change notification to the screen; but if you use Collections.sort(observableList), the change notification is printed four times.
 */
import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;

public class CollectionsVsFXCollectionsChangeNotifications {
	public static void main(String[] args) {

		// Use Java Collections to create the List
		List<String> list = new ArrayList<String>();
		list.add("d");
		list.add("b");
		list.add("a");
		list.add("c");

		// Now add observability by wrapping it with ObservableList
		ObservableList<String> observableList = FXCollections.observableList(list);
		observableList.addListener(new ListChangeListener() {
			@Override
			public void onChanged(ListChangeListener.Change change) {
				System.out.println("Detected a change! ");
			}
		});

		// Sort using FXCollections
		FXCollections.sort(observableList);

	}
}
