import java.util.Hashtable;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Calculator extends Application {

	static String value1 = "";
	static String value2 = "";
	static String operation = null;
	static Hashtable<String, Boolean> hashtable;

	static Text num1Text = new Text();
	static Text operationText = new Text();
	static Text num2Text = new Text();
	static Text equalsText = new Text();
	static Text resultText = new Text();
	
	static ButtonFactory buttonFactory;

	public static void main(String[] args) {
		hashtable = new Hashtable<>();
		hashtable.put("*", true);
		hashtable.put("/", true);
		hashtable.put("+", true);
		hashtable.put("-", true);

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Calculator");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		grid.add(num1Text, 0, 0, 1, 1);
		grid.add(operationText, 1, 0, 1, 1);
		grid.add(num2Text, 2, 0, 1, 1);
		grid.add(equalsText, 3, 0, 1, 1);
		grid.add(resultText, 4, 0, 1, 1);

		buttonFactory = new ButtonFactory();
		grid.add(newNumberButton(7), 0, 1);
		grid.add(newNumberButton(8), 1, 1);
		grid.add(newNumberButton(9), 2, 1);
		grid.add(buttonFactory.getButton("+"), 3, 1);

		grid.add(newNumberButton(4), 0, 2);
		grid.add(newNumberButton(5), 1, 2);
		grid.add(newNumberButton(6), 2, 2);
		grid.add(buttonFactory.getButton("-"), 3, 2);

		grid.add(newNumberButton(1), 0, 3);
		grid.add(newNumberButton(2), 1, 3);
		grid.add(newNumberButton(3), 2, 3);
		grid.add(buttonFactory.getButton("*"), 3, 3);

		grid.add(newNumberButton(0), 0, 4);
		grid.add(buttonFactory.getButton("/"), 3, 4);

		grid.add(buttonFactory.getButton("="), 4, 4);

		Scene scene = new Scene(grid, 300, 275);
		stage.setScene(scene);
		stage.show();
	}

	

	public static HBox newNumberButton(int value) {
		return buttonFactory.getButton(Integer.toString(value));
	}
}
