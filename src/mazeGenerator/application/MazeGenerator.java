package mazeGenerator.application;

import javafx.application.Application;
import javafx.stage.Stage;
import mazeGenerator.view.TitleView;

/**
 * MazeGenerator を起動するクラスです<br>
 * Windowを起動、show()メソッドを実行しアプリを開始します
 * @author BP20083 鈴木直人
 * @see Window
 */
public class MazeGenerator extends Application {
	
	private static final int WINDOW_HEIGHT = 1000;
	private static final int WINDOW_WIDTH = 600;
	
	/**
	 * launchメソッドはApplicationクラスで実装されておりstartメソッドを呼びます
	 * @param args　コマンドライン引数
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Applocationクラスの抽象メソッドを実装します//
	 */
	@Override
	public void start(Stage stage) {
		Window.init(stage, WINDOW_HEIGHT, WINDOW_WIDTH, new TitleView());
		Window.show();
	}
}
