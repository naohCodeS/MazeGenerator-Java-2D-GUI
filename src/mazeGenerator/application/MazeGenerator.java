package mazeGenerator.application;

import javafx.application.Application;
import javafx.stage.Stage;
import mazeGenerator.view.TitleView;

/**
 * MazeGenerator ���N������N���X�ł�<br>
 * Window���N���Ashow()���\�b�h�����s���A�v�����J�n���܂�
 * @author BP20083 ��ؒ��l
 * @see Window
 */
public class MazeGenerator extends Application {
	
	private static final int WINDOW_HEIGHT = 1000;
	private static final int WINDOW_WIDTH = 600;
	
	/**
	 * launch���\�b�h��Application�N���X�Ŏ�������Ă���start���\�b�h���Ăт܂�
	 * @param args�@�R�}���h���C������
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Applocation�N���X�̒��ۃ��\�b�h���������܂�//
	 */
	@Override
	public void start(Stage stage) {
		Window.init(stage, WINDOW_HEIGHT, WINDOW_WIDTH, new TitleView());
		Window.show();
	}
}
