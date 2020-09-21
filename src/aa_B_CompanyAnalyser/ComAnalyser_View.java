package aa_B_CompanyAnalyser;

import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComAnalyser_View {
	
	// 0 View muss Stage und Model kennen
	private Stage stage;
	private ComAnalyser_Model model;

	// Controls
	TextField searchField = new TextField();

	// Layouts




	
	// 0
	// Konstruktor
	public ComAnalyser_View(Stage stage, ComAnalyser_Model model) {
		this.stage = stage;
		this.model = model;
		
		// 0 Wurzel als Hauptbehälter
		BorderPane root = new BorderPane();
		VBox rootCenter = new VBox();
		
		
		root.setCenter(rootCenter); // LEFT
		rootCenter.getChildren().add(createCompanyChart());
		
		
		// 0 Create the scene using our layout; then display it
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("ComAnalyserStyle.css").toExternalForm());
		stage.setScene(scene);
		stage.setTitle("Company Analyser");
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
	
	
	private LineChart createCompanyChart() {
		final CategoryAxis xAxis = new CategoryAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Month");
		final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);

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
		lineChart.getData().addAll(series1, series2, series3);
		
		return lineChart;
	}

}
