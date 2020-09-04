package topic_06_IO_Lists_Tables_FileExercise;

import java.util.ArrayList;

public class FileExercise_Controller {
	private final FileExercise_View view;
	private final FileExercise_Model model;

	public FileExercise_Controller(FileExercise_View view, FileExercise_Model model) {
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
