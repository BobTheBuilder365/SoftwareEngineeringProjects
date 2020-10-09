package aa_A_KeyConcepts.g.InputOutputEnumeration.READText;

import java.util.ArrayList;

import topic_06_IO_Lists_Tables_FileExercise.FileExercise_Model;
import topic_06_IO_Lists_Tables_FileExercise.FileExercise_View;

public class ReadTextFile_Controller {

	private final ReadTextFile_View view;
	private final ReadTextFile_Model model;

	public ReadTextFile_Controller(ReadTextFile_View view, ReadTextFile_Model model) {
		this.view = view;
		this.model = model;

		view.btnRead.setOnAction(event -> {
			model.readFile_v1();
			if (model.hasNumbers()) {
				view.lblNumbers.setText(getNumbersAsString());
				view.lblTotal.setText("Total is " + model.calculateTotal());
			} else {
				view.lblTotal.setText("There are no numbers");
			}
		});
	}

	private String getNumbersAsString() {
		ArrayList<Integer> numbers = model.getNumbers();
		StringBuffer sb = new StringBuffer();
		for (Integer number : numbers)
			sb.append(number + " ");
		return sb.toString();
	}
}
