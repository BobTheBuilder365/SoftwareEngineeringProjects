package topic_00_poker.view;

import javafx.scene.control.Label;
import topic_00_poker.model.Card;

public class CardLabel extends Label {
	public CardLabel() {
		super();
		this.getStyleClass().add("card");
	}
	
	public void setCard(Card card) {
		if (card != null)
			this.setText(card.toString());
		else
			this.setText("");
	}
}
