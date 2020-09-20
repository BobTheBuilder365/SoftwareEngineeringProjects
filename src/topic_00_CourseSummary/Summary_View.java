package topic_00_CourseSummary;

import javafx.animation.RotateTransition;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import tictactoe.TicTacToe_Model;
import topic_00_CourseSummary.Pet.Gender;
import topic_00_CourseSummary.Pet.Species;

// 0
public class Summary_View {
	
	// 0 View muss das Model und die Stage kennen
	final private Summary_Model model;
	final private Stage stage;

    // 1.1 Dice
	Button[] dice = new Button[2]; // Array for buttons

	
	// 1.1 Pet - Properties Bindings
	TextField txtName = new TextField();
	ComboBox<Species> cmbSpecies = new ComboBox<>();
	ComboBox<Gender> cmbGender = new ComboBox<>();
	Label lblDataID = new Label();
	Label lblDataName = new Label();
	Label lblDataSpecies = new Label();
	Label lblDataGender = new Label();
	// Buttons
	Button btnSave = new Button("Save");
	Button btnDelete = new Button("Delete");
	
	
	// 1.1 TicTacToe
	protected Button[][] buttons = new Button[TicTacToe_Model.BOARD_SIZE][TicTacToe_Model.BOARD_SIZE];
	
	
	// 1.1 EmailValidator
    protected TextField txtEmail;
    
    // 1.1 ModelPropertyExample
    private RotateTransition rotate;
    protected Label lblNumber;
	protected Button btnClick;
    
	
	// 1.1 LineChartExample
	protected CategoryAxis xAxis = new CategoryAxis();
	protected NumberAxis yAxis = new NumberAxis();
	protected LineChart<String,Number> lineChart = 
            new LineChart<String,Number>(xAxis,yAxis);
	
	// 0 Konstruktor
	public Summary_View(Stage primaryStage, Summary_Model model) {
		// TODO Auto-generated constructor stub
		this.stage = primaryStage;
		this.model = model;

		// 0 Wurzel als Hauptbehälter und Boxen für die Regionen
		BorderPane root = new BorderPane();
		HBox rootTop = new HBox();
		HBox rootBottom = new HBox();
		VBox rootLeft = new VBox();
		VBox rootRight = new VBox();
		
		
		// 1 Pet - Properties Bindings
		// Das GUI wird mit der Methode erzeugt und platziert		
		root.setLeft(rootLeft); // LEFT
		rootLeft.getChildren().add(createDataEntryPane());
		rootLeft.getChildren().add(createControlPane());
		rootLeft.getChildren().add(createDataDisplayPane());		
		
		
		// 1 Right - TicTacToe, Dice
		root.setRight(rootRight);
		rootRight.getChildren().add(createTicTacToePane()); // TicTacToePane	
		rootRight.getChildren().add(createDicePane()); // Dice
		
		// 1 EmailValidator
		root.setTop(rootTop);
		rootTop.getChildren().add(createEmailValidatorPane()); // TOP
		
		// 1 ModelPropertyExample
		root.setBottom(rootBottom);
		rootBottom.getChildren().add(createMPEPane()); // BOTTOM

		// 1 LineChartExample
		// Das GUI wird mit der Methode erzeugt und platziert
		root.setCenter(createLineChartPane()); // CENTER
		
		// 0 Create the scene using our layout; then display it
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("SummaryCSS.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Summary");
		stage.setResizable(true);
	}

	// 0
	public void start() {
		// TODO Auto-generated method stub
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
	/**
	 * 3.2 ModelPropertyExample
	 * Method to allow the controller to trigger an animation
	 */
	public void doAnimate() {
		rotate.play();
	}

	// 1 Dice - Methode um das GUI zu erzeugen
	private Pane createDicePane() {
		GridPane root = new GridPane();
		for (int i = 0; i < 2; i++) {
			dice[i] = new Button("1");
			root.add(dice[i], i, 0);
		}
		return root;
	}

	
	// 1 Pet - Properties Bindings - Methode um Teil des GUIs zu erzeugen
	private Pane createDataEntryPane() {
		GridPane pane = new GridPane();
		pane.setId("dataEntry");
		// Declare the individual controls in the GUI
		Label lblName = new Label("Name");
		Label lblSpecies = new Label("Species");
		Label lblGender = new Label("Gender");
		
		// Fill combos
		cmbSpecies.getItems().addAll(Pet.Species.values());
		cmbSpecies.setValue(Species.CAT);
		cmbGender.getItems().addAll(Pet.Gender.values());
		cmbGender.setValue(Gender.FEMALE);
		
		// Organize the layout, add in the controls (col, row)
		pane.add(lblName, 0, 0);		pane.add(txtName, 1, 0);
		pane.add(lblSpecies, 0, 1);		pane.add(cmbSpecies, 1, 1);
		pane.add(lblGender, 0, 2);	pane.add(cmbGender, 1, 2);
		
		return pane;
	}
	// 1 Pet - Properties Bindings - Methode um Teil des GUIs zu erzeugen
	private Pane createControlPane() {
		GridPane pane = new GridPane();
		pane.setId("controlArea");
		pane.add(btnSave, 0, 0);
		pane.add(btnDelete, 1, 0);
		
		return pane;
	}
	// 1 Pet - Properties Bindings - Methode um Teil des GUIs zu erzeugen
	private Pane createDataDisplayPane() {
		GridPane pane = new GridPane();
		pane.setId("dataDisplay");
		// Declare the individual controls in the GUI
	    Label lblID = new Label("ID");
		Label lblName = new Label("Name");
		Label lblSpecies = new Label("Species");
		Label lblGender = new Label("Gender");
		
		// Organize the layout, add in the controls (col, row)
	    pane.add(lblID, 0, 0); pane.add(lblDataID, 1, 0);
	    pane.add(lblName, 0, 1); pane.add(lblDataName, 1, 1);
	    pane.add(lblSpecies, 0, 2); pane.add(lblDataSpecies, 1, 2);
	    pane.add(lblGender, 0, 3); pane.add(lblDataGender, 1, 3);
	    
	    return pane;
	}

	
	// 1 TicTacToe 
	private Pane createTicTacToePane() {
		GridPane grid = new GridPane();
		
		for (int col = 0; col < TicTacToe_Model.BOARD_SIZE; col++) {
			for (int row = 0; row < TicTacToe_Model.BOARD_SIZE; row++) {
				// Create button for this position
				Button btn = new Button();
				buttons[col][row] = btn;
				grid.add(btn, col, row);
			}
		}		
		
		return grid;
	}

	
	// 1 EmailValidator
	private Pane createEmailValidatorPane() {
		GridPane grid = new GridPane();
		txtEmail = new TextField();
		grid.add(txtEmail, 0, 0);
		return grid;
	}

	
	// 1 ModelPropertExample
	private Pane createMPEPane() {
		
		GridPane root = new GridPane();
		lblNumber = new Label();
		lblNumber.setText(Integer.toString(model.getValue()));
		root.add(lblNumber, 0, 0);
		
		btnClick = new Button();
		btnClick.setText("Click Me!");
		root.add(btnClick, 0, 1);
		
		// Prepare animation for use
		rotate = new RotateTransition(Duration.millis(500));
		rotate.setByAngle(360);
		rotate.setCycleCount(1);
		rotate.setNode(lblNumber);
		return root;
	}

	private Pane createLineChartPane() {
		GridPane pane = new GridPane();
		
		xAxis.setLabel("Month");
       
        lineChart.setTitle("Stock Monitoring, 2010");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Portfolio 1");
        
        series1.getData().add(new XYChart.Data("Jan", 23));
        series1.getData().add(new XYChart.Data("Feb", 14));
        series1.getData().add(new XYChart.Data("Mar", 15));
        series1.getData().add(new XYChart.Data("Apr", 24));
        series1.getData().add(new XYChart.Data("May", 34));
        series1.getData().add(new XYChart.Data("Jun", 36));
        series1.getData().add(new XYChart.Data("Jul", 22));
        series1.getData().add(new XYChart.Data("Aug", 45));
        series1.getData().add(new XYChart.Data("Sep", 43));
        series1.getData().add(new XYChart.Data("Oct", 17));
        series1.getData().add(new XYChart.Data("Nov", 29));
        series1.getData().add(new XYChart.Data("Dec", 25));
        
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Portfolio 2");
        series2.getData().add(new XYChart.Data("Jan", 33));
        series2.getData().add(new XYChart.Data("Feb", 34));
        series2.getData().add(new XYChart.Data("Mar", 25));
        series2.getData().add(new XYChart.Data("Apr", 44));
        series2.getData().add(new XYChart.Data("May", 39));
        series2.getData().add(new XYChart.Data("Jun", 16));
        series2.getData().add(new XYChart.Data("Jul", 55));
        series2.getData().add(new XYChart.Data("Aug", 54));
        series2.getData().add(new XYChart.Data("Sep", 48));
        series2.getData().add(new XYChart.Data("Oct", 27));
        series2.getData().add(new XYChart.Data("Nov", 37));
        series2.getData().add(new XYChart.Data("Dec", 29));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("Portfolio 3");
        series3.getData().add(new XYChart.Data("Jan", 44));
        series3.getData().add(new XYChart.Data("Feb", 35));
        series3.getData().add(new XYChart.Data("Mar", 36));
        series3.getData().add(new XYChart.Data("Apr", 33));
        series3.getData().add(new XYChart.Data("May", 31));
        series3.getData().add(new XYChart.Data("Jun", 26));
        series3.getData().add(new XYChart.Data("Jul", 22));
        series3.getData().add(new XYChart.Data("Aug", 25));
        series3.getData().add(new XYChart.Data("Sep", 43));
        series3.getData().add(new XYChart.Data("Oct", 44));
        series3.getData().add(new XYChart.Data("Nov", 45));
        series3.getData().add(new XYChart.Data("Dec", 44));
        
        pane.add(lineChart,0,1);       
        lineChart.getData().addAll(series1, series2, series3);
		return pane;
	}


}