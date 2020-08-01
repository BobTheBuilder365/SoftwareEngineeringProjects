package topic_04_JavaFX_PropertiesBindings.petExercise.v1;

public class PetController {
	private PetView view;
	private PetModel model;

	public PetController(PetModel model, PetView view) {
		this.model = model;
		this.view = view;
	}
}
