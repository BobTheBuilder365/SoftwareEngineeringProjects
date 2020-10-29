package aa_A_KeyConcepts.h.Datenstrukturen.JavaFXCollections;

// Having reviewed the most relevant areas of the Java Collections Framework, you are now ready to learn how Collections are represented in JavaFX.
public class LearningJavaFXCollections {

	/*
	 * Learning JavaFX Collections
	 * 
	 * Collections in JavaFX are defined by the javafx.collections package, which
	 * consists of the following interfaces and classes:
	 * 
	 * Interfaces
	 * 
	 * ObservableList: A list that enables listeners to track changes when they
	 * occur
	 * 
	 * ListChangeListener: An interface that receives notifications of changes to an
	 * ObservableList
	 * 
	 * ObservableMap: A map that enables observers to track changes when they occur
	 * 
	 * MapChangeListener: An interface that receives notifications of changes to an
	 * ObservableMap
	 * 
	 * Classes
	 * 
	 * FXCollections: A utility class that consists of static methods that are
	 * one-to-one copies of java.util.Collections methods
	 * 
	 * ListChangeListener.Change: Represents a change made to an ObservableList
	 * 
	 * MapChangeListener.Change: Represents a change made to an ObservableMap
	 * 
	 * The following section explains how to use these interfaces and classes
	 * 
	 * Using ObservableList, ObservableMap, and FXCollections
	 * 
	 * The javafx.collections.ObservableList and javafx.collections.ObservableMap
	 * interfaces both extend javafx.beans.Observable (and java.util.List or
	 * java.util.Map, respectively) to provide a List or Map that supports
	 * observability. If you look at the API specification for either of these
	 * interfaces, you will find methods for adding or removing the appropriate
	 * listeners (ListChangeListener for ObservableList, and MapChangeListener for
	 * ObservableMap). Unlike the previous List and Map examples — which used
	 * ArrayList and HashMap as their concrete implementations — Example 4 uses the
	 * javafx.collections.FXCollections class to create and return the
	 * ObservableList and ObservableMap objects.
	 */
}
