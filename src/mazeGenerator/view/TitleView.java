package mazeGenerator.view;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import mazeGenerator.application.Window;
import mazeGenerator.guiComponent.TitleSubText;
import mazeGenerator.guiComponent.TitleText;
import mazeGenerator.guiComponent.TitleTextField;

/**
 * タイトル画面のクラスです<br>
 * VireFrameを継承します
 * @author BP20083 鈴木直人
 */
public class TitleView extends ViewFrame{
	
	private static final int MINIMUM_SIZE = 5;
	
	private int width;
	private int height;
	
	/**
	 * タイトル画面の初期化を行います
	 */
	public TitleView() {
		width = height = MINIMUM_SIZE;
		
		TitleText title = new TitleText("MazeGenerator");
		
		
		TitleSubText heightText = new TitleSubText("縦ブロック数 : ");
		TitleSubText widthText = new TitleSubText("横ブロック数 : ");
		
		TitleTextField heightTextField = new TitleTextField("縦ブロック数を入力してください");
		TitleTextField widthTextField = new TitleTextField("横ブロック数を入力してください");
		
		Label heightLabel = new Label();
		Label widthLabel = new Label();
		
		Button executeButton = new Button("迷路生成");
		
		executeButton.setFont(new Font(15));
		executeButton.setPrefSize(100, 50);
		executeButton.setOnAction(event ->{
			heightLabel.setText(heightTextField.getText());
			widthLabel.setText(widthTextField.getText());
			if(heightLabel.getText().equals("")||widthLabel.getText().equals("")) 
				new Alert(AlertType.ERROR, "ブロック数を入力してください").showAndWait();
			else {
				height = Integer.parseInt(heightLabel.getText());
				width = Integer.parseInt(widthLabel.getText());
				if(height<5||width<5||height%2==0||width%2==0) 
					new Alert(AlertType.ERROR, "ブロック数は5以上の奇数を設定してください").showAndWait();
				else Window.change(new MazeView(height, width));
			}
		});
		
		HBox heightBox = new HBox();
		HBox widthBox = new HBox();
		HBox execution = new HBox();
		
		VBox centerLayout = new VBox();
		
		centerLayout.setLayoutY(150);
		
		heightBox.setAlignment(Pos.CENTER);
		widthBox.setAlignment(Pos.CENTER);
		execution.setAlignment(Pos.CENTER);
		
		execution.getChildren().add(executeButton);
		heightBox.getChildren().addAll(heightText, heightTextField);
		widthBox.getChildren().addAll(widthText, widthTextField);

		centerLayout.getChildren().addAll(title, heightBox, widthBox, execution);
		
		VBox.setMargin(execution, new Insets(10));
		
		getChildren().add(centerLayout);
	}
	
	
	/**
	 * 縦ブロック数を返します
	 * @return 縦ブロック数
	 */
	public int getHeight() {return this.height;}
	/**
	 * 横ブロック数を返します
	 * @return 横ブロック数
	 */
	public int getWidth() {return this.width;}
}
