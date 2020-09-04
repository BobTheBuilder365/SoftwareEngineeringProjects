package topic_00_JavaFX_OverwatchNEW;

import javafx.geometry.Insets;

// Stufe 0 = Basis MVC Struktur und die View

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import topic_06_IO_Lists_Tables_tableViewExampleEDITABLE.SuperNumber;

public class OverwatchView {
	
	// 0 View muss das model und die stage kennen
	final private OverwatchModel model;
	final private Stage stage;
	
//	protected BorderPane root;
//	protected VBox vBox;
//	protected HBox hBox, hBox1, hBox2 = new HBox();
	
	// Define the fields in the GUI
	
	// ButtonCLick (0)
	protected Button btnClick;
	protected Label lblNumber;
	
	// Calculator (0)
	protected TextField txtCalc;
	protected Button digits[] = new Button[10];
	protected Button btnPlus;
	protected Button btnClear;
	protected Button btnEquals;
	
	// EventTypes
	protected Button btnEventClick = new Button("I am a button with lots of events!");
    protected TextArea txtEventLog = new TextArea();
    
    // EventHandling
    protected Label lblAnonClass = new Label("Anon. Class");
    protected Label lblLambda = new Label("Lambda");
    protected Label lblMethodReference = new Label("Method Ref.");
	protected Label lblEventHandlingNumber = new Label();
	protected Button btnClickAnonClass = new Button("inc. with AnonClass!");
	protected Button btnClickLambda = new Button("inc. with Lambda!");
	protected Button btnClickMethRef = new Button("inc. with MethRef!");
	
	// Events.DynamicCSS
    protected Label lblAddStyle = new Label("Styles changed by MouseEnter/MouseExit");
    protected Label lblAddClass = new Label("Classes changed by MouseEnter/MouseExit");
    
    // Dice
	Button[] dice = new Button[2]; // Array for buttons
	
	// ListView (read only - generally just addable and multi selectable)
	protected ListView<Integer> listView;	
	protected Button btnAddNewElt = new Button("Add New Element");
	protected Button btnMultiply = new Button("Multiply by 2");
	protected Label lblResult = new Label();
	
	// Editable TableView
//	protected Button tablieViewAddBtn = new Button("Add New Element");
//	protected TableView<SuperNumber> tableView;
//	protected TableColumn<SuperNumber, String> colBinary;
//	protected TableColumn<SuperNumber, String> colDecimal;
//	protected TableColumn<SuperNumber, String> colHex;
	
	// 0 Konstruktor
	public OverwatchView(Stage primaryStage, OverwatchModel model) {
		this.stage = primaryStage;
		this.model = model;
		
		// 0 Wurzel als Hauptbehälter
		BorderPane root = new BorderPane();
		HBox rootTop = new HBox();
		VBox rootLeft = new VBox();
		BorderPane rootCenter = new BorderPane();
		VBox rootRight = new VBox();
		HBox rootBottom = new HBox();
		
		
		root.setTop(rootTop);
		root.setLeft(rootLeft);
		root.setCenter(rootCenter);
		root.setRight(rootRight);
		root.setBottom(rootBottom);
		
		// rootCenter - Center
		rootCenter.setCenter(createListViewPane());
		
		// TOP
		rootTop.getChildren().add(createButtonClickPane());
		rootTop.getChildren().add(createCalculatorPane());
		rootTop.getChildren().add(createDicePane());
		
		// BOTTOM
		rootBottom.getChildren().add(createEventTypesPane());
		rootBottom.getChildren().add(createEventHandlingPane());
		rootBottom.getChildren().add(createDynamicCSSVBox());


		
		
		// 0 Standard stuff for Scene and Stage
		Scene scene = new Scene(root);
		scene.getStylesheets().add(
				getClass().getResource("OverwatchStyle.css").toExternalForm());
		stage.setTitle("Overwatch Software Engineering JavaFX");
		stage.setScene(scene);
		stage.show();
	}

	// 0
	public void start() {
		stage.show();	
	}
	/**
	 * 0 - Getter for the stage, so that the controller can access window events
	 */
	public Stage getStage() {
		return stage;
	}
	/**
	 * 0 - Optional. An opportunity to clean house, for example, disconnecting from
	 * a database or network server, before the program ends.
	 */
	public void stop() {
		stage.hide();
	}	
	
	// 0 Buttonclick - erzeugt das GUI
	private Pane createButtonClickPane() {
		GridPane pane = new GridPane();
		lblNumber = new Label();
		// Hol im Model den Wert von value, konvertiere Intger to String und setze als Text im Label
		lblNumber.setText(Integer.toString(model.getValue()));
		pane.add(lblNumber, 0, 0);
		btnClick = new Button();
		btnClick.setText("Click Me!");
		pane.add(btnClick, 0, 1);
		
		return pane;
	}
	
	// 0 Calculator - erzeugt das GUI
	private Pane createCalculatorPane() {
		
		BorderPane pane = new BorderPane();
		txtCalc = new TextField();
		txtCalc.setDisable(true);
		pane.setTop(txtCalc);
		
		GridPane buttons = new GridPane();
		pane.setCenter(buttons);
		
		for (int i = 0; i < digits.length; i++) {
			digits[i] = new Button(Integer.toString(i));
		}
		
		// special add for button 0
		buttons.add(digits[0], 0, 3, 3, 1);
		
		// add all other digits
		for (int i = 1; i < digits.length; i++) {
			buttons.add(digits[i], (i-1) % 3, 2 - (i-1) / 3);
		}		
		
		btnPlus = new Button("+");
		buttons.add(btnPlus, 3, 0);
		
		btnClear = new Button("C");
		buttons.add(btnClear, 3, 1);
		
		btnEquals = new Button("=");
		buttons.add(btnEquals, 3, 2, 1, 2);
		
		// Configure grid columns and rows to resize to available space
		// See "GridPane" in the JavaFX API, section "Percentage Sizing"
		ColumnConstraints cc = new ColumnConstraints();
		cc.setPercentWidth(25);
		buttons.getColumnConstraints().addAll(cc, cc, cc, cc);
		RowConstraints rc = new RowConstraints();
		rc.setPercentHeight(25);
		buttons.getRowConstraints().addAll(rc, rc, rc, rc);
		
		return pane;
	}

	// 0 EventTypes GUI
	private Pane createEventTypesPane() {
		GridPane grid = new GridPane();
		grid.add(btnEventClick, 0, 1);
		grid.addColumn(0, txtEventLog);
		return grid;
		
	}
	
	// 0 EventHandling
	private Pane createEventHandlingPane() {

		GridPane root = new GridPane();
		lblEventHandlingNumber.setText(Integer.toString(model.getValueEH()));
		root.addRow(0,  lblAnonClass, lblLambda, lblMethodReference);
		root.addRow(1,  btnClickAnonClass, btnClickLambda, btnClickMethRef);
		root.add(lblEventHandlingNumber, 0, 2, 3, 1);
		lblEventHandlingNumber.setId("Number");
		return root;
	}
		
	// 0 Events.DynamicCSS GUI
	private VBox createDynamicCSSVBox() {
		VBox root = new VBox();
		root.getChildren().addAll(lblAddStyle, lblAddClass);
		root.getStyleClass().add("vbox");
		
		return root;
	}

	// 0 Dice
	private Pane createDicePane() {
		GridPane root = new GridPane();
		for (int i = 0; i < 2; i++) {
			dice[i] = new Button("1");
			root.add(dice[i], i, 0);
		}
		return root;
	}
	
	// ListView
	private Pane createListViewPane(){
		// INITIALIZE LISTVIEW: BIND TO OBSERVABLELIST IN MODEL
		// Wir teilen dem ListeView Objekt mit wo die Daten zu finden sind
		// verbinden somit MODEL & VIEW - die listView abonniert automatische
		// alle Events der ObserveableList
		listView = new ListView<Integer>(model.getIntegerElements());
		// Lower HBox for multiplication
		HBox.setHgrow(lblResult, Priority.ALWAYS); // Resize goes to the label
		HBox hbox = new HBox(btnMultiply, lblResult);		
		// Layout root pane
		VBox root = new VBox();
//		root.getStyleClass().add("rootListView"); // Class for styling
//		root.getStyleClass().add("labelListView"); // Class for styling
//		VBox.setVgrow(listView, Priority.ALWAYS); // Vertical resize goes to the listView
		root.getChildren().addAll(listView, btnAddNewElt, hbox);

		// Size constraints
		btnAddNewElt.setMaxWidth(Double.MAX_VALUE); // button can grow horizontally		
		return root;
	
	}
	

	
	// Editable TableView
//	private TableView<SuperNumber> createEditableTableView() {
//
//		TableView<SuperNumber> tableView = new TableView<>();
//		tableView.setEditable(true); // EDITIEREN ERMÖGLICHEN
//		
//		// Layout root pane
//		VBox root = new VBox();
//		root.setPadding(new Insets(10)); // around edge of VBox
//		root.setSpacing(10); // between elements
//		VBox.setVgrow(tableView, Priority.ALWAYS); // Vertical resize goes to the table
//		root.getChildren().addAll(tableView, tablieViewAddBtn);
//
//		// Size constraints
//		tablieViewAddBtn.setMaxWidth(Double.MAX_VALUE); // button can grow horizontally
//
//		// Each column needs a title, and a source of data.
//		// For editable columns, each column needs to contain a TextField.
//		colBinary = new TableColumn<>("Binary");
//		colBinary.setCellFactory(TextFieldTableCell.forTableColumn());
//		colBinary.setCellValueFactory(c -> c.getValue().asBinaryProperty());
//		tableView.getColumns().add(colBinary);
//
//		colDecimal = new TableColumn<>("Decimal");
//		colDecimal.setCellFactory(TextFieldTableCell.forTableColumn());
//		colDecimal.setCellValueFactory(c -> c.getValue().asDecimalProperty());
//		tableView.getColumns().add(colDecimal);
//
//		colHex = new TableColumn<>("Hexadecimal");
//		colHex.setCellFactory(TextFieldTableCell.forTableColumn());
//		colHex.setCellValueFactory(c -> c.getValue().asHexadecimalProperty());
//		tableView.getColumns().add(colHex);
//
//		// Finally, attach the tableView to the ObservableList of data
//		tableView.setItems(model.getElements());
//
//		return tableView;
//	}


}
