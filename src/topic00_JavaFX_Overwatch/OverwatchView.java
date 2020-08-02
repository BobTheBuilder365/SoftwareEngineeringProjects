package topic00_JavaFX_Overwatch;

// Stufe 0 = Basis MVC Struktur und die View

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OverwatchView {
	
	// 0 View muss das model und die stage kennen
	final private OverwatchModel model;
	final private Stage stage;
	
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
	
	// 0 Konstruktor
	public OverwatchView(Stage primaryStage, OverwatchModel model) {
		this.stage = primaryStage;
		this.model = model;
		
		// 0 Wurzel als Hauptbehälter
		BorderPane root = new BorderPane();
		BorderPane rootTop = new BorderPane();
		BorderPane rootLeft = new BorderPane();
		BorderPane rootCenter = new BorderPane();
		BorderPane rootRight = new BorderPane();
		BorderPane rootBottom = new BorderPane();
		
		root.setTop(rootTop);
		root.setLeft(rootLeft);
		root.setCenter(rootCenter);
		root.setRight(rootRight);
		root.setBottom(rootBottom);
		
		rootTop.setCenter(createDicePane());
		
		rootCenter.setTop(createButtonClickPane());
		rootCenter.setLeft(createCalculatorPane());
		rootCenter.setCenter(createEventTypesPane());
		rootCenter.setRight(createDynamicCSSVBox());
		rootCenter.setBottom(createEventHandlingPane());

		
		
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
		// TODO Auto-generated method stub
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
		lblNumber.setId("Number");
		return root;
	}
		
	// 0 Events.DynamicCSS
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
}
