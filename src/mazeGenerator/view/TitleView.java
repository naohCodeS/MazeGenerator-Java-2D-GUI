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
 * �^�C�g����ʂ̃N���X�ł�<br>
 * VireFrame���p�����܂�
 * @author BP20083 ��ؒ��l
 */
public class TitleView extends ViewFrame{
	
	private static final int MINIMUM_SIZE = 5;
	
	private int width;
	private int height;
	
	/**
	 * �^�C�g����ʂ̏��������s���܂�
	 */
	public TitleView() {
		width = height = MINIMUM_SIZE;
		
		TitleText title = new TitleText("MazeGenerator");
		
		
		TitleSubText heightText = new TitleSubText("�c�u���b�N�� : ");
		TitleSubText widthText = new TitleSubText("���u���b�N�� : ");
		
		TitleTextField heightTextField = new TitleTextField("�c�u���b�N������͂��Ă�������");
		TitleTextField widthTextField = new TitleTextField("���u���b�N������͂��Ă�������");
		
		Label heightLabel = new Label();
		Label widthLabel = new Label();
		
		Button executeButton = new Button("���H����");
		
		executeButton.setFont(new Font(15));
		executeButton.setPrefSize(100, 50);
		executeButton.setOnAction(event ->{
			heightLabel.setText(heightTextField.getText());
			widthLabel.setText(widthTextField.getText());
			if(heightLabel.getText().equals("")||widthLabel.getText().equals("")) 
				new Alert(AlertType.ERROR, "�u���b�N������͂��Ă�������").showAndWait();
			else {
				height = Integer.parseInt(heightLabel.getText());
				width = Integer.parseInt(widthLabel.getText());
				if(height<5||width<5||height%2==0||width%2==0) 
					new Alert(AlertType.ERROR, "�u���b�N����5�ȏ�̊��ݒ肵�Ă�������").showAndWait();
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
	 * �c�u���b�N����Ԃ��܂�
	 * @return �c�u���b�N��
	 */
	public int getHeight() {return this.height;}
	/**
	 * ���u���b�N����Ԃ��܂�
	 * @return ���u���b�N��
	 */
	public int getWidth() {return this.width;}
}
