package app.view;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class Titulo extends HBox{
	
	
	public Titulo(Label label) {
		setMaxHeight(50);
		getChildren().add(label);
	}
}
