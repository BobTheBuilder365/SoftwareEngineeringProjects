package topic_11_Threads;

import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class AnnoyThread1 extends Thread {
	private Annoy1 parent;
	private volatile boolean stop;
	private Color color = Color.WHITE;

	public AnnoyThread1(Annoy1 parent, String name) {
		super(name);
		this.parent = parent;
		this.setDaemon(true);
		this.stop = false;
	}

	public void pleaseStop() {
		stop = true;
	}

	public void run() {
		Node root = parent.getRoot();
		while (!stop) {
			if (color.equals(Color.WHITE)) {
				color = Color.BLACK;
			} else {
				color = Color.WHITE;
			}
			changeStyle(root, color);
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
		}
	}
	
	private void changeStyle(Node element, Color color) {
		Platform.runLater(() -> {
			if (color.equals(Color.WHITE)) {
				element.getStyleClass().remove("white");
				element.getStyleClass().add("black");
			} else {
				element.getStyleClass().remove("black");
				element.getStyleClass().add("white");
			}
		});
	}
}
