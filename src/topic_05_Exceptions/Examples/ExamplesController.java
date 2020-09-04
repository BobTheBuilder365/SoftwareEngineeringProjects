package topic_05_Exceptions.Examples;

public class ExamplesController {
	private ExamplesModel model;
	private ExamplesView view;

	public ExamplesController(ExamplesModel model, ExamplesView view) {
		this.model = model;
		this.view = view;

		view.btnStack.setOnAction(e -> stackOverflow());
		view.btnArrayIndex.setOnAction(e -> arrayIndex());
		view.btnInteger.setOnAction(e -> parseInteger(view.txtInteger.getText()));
		view.btnFile.setOnAction(e -> openFile(view.txtFile.getText()));
	}

	private void stackOverflow() {
		String result = model.stackOverflow();
		view.lblStackResult.setText(result);
	}

	private void arrayIndex() {
		String result = model.arrayIndex();
		view.lblArrayIndexResult.setText(result);
	}

	private void parseInteger(String s) {
		String result = model.parseInteger(s);
		view.lblIntegerResult.setText(result);
	}

	private void openFile(String path) {
		String result = model.openFile(path);
		view.lblFileResult.setText(result);
	}
}
