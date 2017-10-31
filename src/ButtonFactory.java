import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonFactory {
	public HBox getButton(String value) {
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.TOP_LEFT);

		Button button = new Button(value);
		button.setOnAction(event -> {
			if (value.equals("=")) {
				int result = 0;
				int num1 = Integer.parseInt(Calculator.value1);
				int num2 = Integer.parseInt(Calculator.value2);
				if (Calculator.operation.equals("+"))
					result = num1 + num2;
				else if (Calculator.operation.equals("-"))
					result = num1 - num2;
				else if (Calculator.operation.equals("*"))
					result = num1 * num2;
				else if (Calculator.operation.equals("/"))
					result = num1 / num2;
				System.out.println("" + result);
				Calculator.equalsText.setText("=");
				Calculator.resultText.setText("" + result);
			} else if (Calculator.hashtable.containsKey(value)) {
				Calculator.operation = value;
				Calculator.operationText.setText(Calculator.operation);
				System.out.println(Calculator.operation);
			} else if (Calculator.operation == null) {
				Calculator.value1 += value;
				Calculator.num1Text.setText(Calculator.value1);
				System.out.println(Calculator.value1);
			} else {
				Calculator.value2 += value;
				Calculator.num2Text.setText(Calculator.value2);
				System.out.println(Calculator.value2);
			}
		});

		hbBtn.getChildren().add(button);
		return hbBtn;
	}
}
