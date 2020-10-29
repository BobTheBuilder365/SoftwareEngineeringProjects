package aa_A_KeyConcepts.h.Datenstrukturen.JavaFXCollections;

// Example 4 Using an ObservableList
/*
 * In Example 4, a standard List is first created. It is then wrapped with an ObservableList, which is obtained by passing the list to FXCollections.observableList(list). A ListChangeListener is then registered, and will receive notification whenever a change is made on the ObservableList.
 */
import java.util.List;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import javafx.collections.ListChangeListener;
import javafx.collections.FXCollections;

public class FXCollectionsDemoUsingAObservableList {
	
	public static void main(String[] args) {

		// Use Java Collections to create the List.
		List<String> list = new ArrayList<String>();

		// Now add observability by wrapping it with ObservableList.
		ObservableList<String> observableList = FXCollections.observableList(list);
		observableList.addListener(new ListChangeListener() {

			@Override
			public void onChanged(ListChangeListener.Change change) {
				System.out.println("Detected a change! ");
			}
		});

		// Changes to the observableList WILL be reported.
		// This line will print out "Detected a change!"
		observableList.add("item one");

		// Changes to the underlying list will NOT be reported
		// Nothing will be printed as a result of the next line.
		list.add("item two");

		System.out.println("Size: " + observableList.size());

	}
}
