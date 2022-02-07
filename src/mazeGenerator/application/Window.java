package mazeGenerator.application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import mazeGenerator.view.ViewFrame;

/**
 * ウィンドウの制御を行うクラスです<br>
 * 初期化、画面の遷移を実装します
 * @author naohS
 */
public class Window {

	private static final Window window = new Window();
	private Stage wnd;
	private Scene scene;
//	private ViewFrame current;
//	private boolean isChangeAnimation;
	private boolean isInit;

	//外部からのアクセスは必要ない
	private Window() {}

	/**
	 * クラスの初期化を行います
	 * @param stage Stageクラスのインスタンス
	 * @param width 画面の幅
	 * @param height 画面の高さ
	 * @param initView 最初に表示するシーン
	 */
	public static synchronized void init(Stage stage, double width, double height, ViewFrame initView) {
		if ( window.isInit ) throw new RuntimeException("既に初期化されています。");
		window.scene = new Scene(initView, width, height);
		stage.setResizable(false);
		stage.setScene(window.scene);
		window.wnd = stage;
//		window.current = initView;
		window.isInit = true;
	}
	
	/**
	 * 画面表示を行うメソッドです
	 */
	public static synchronized void show() {
		if(!window.wnd.isShowing()) window.wnd.show();
	}
	
//	public static synchronized void close() {
//		if(window.wnd.isShowing()) window.wnd.close();
//	}
	
	
	/**
	 * 画面の遷移を行います
	 * @param view 遷移先のSceneクラスインスタンス
	 */
	public static void change(ViewFrame view) {
		window.scene.setRoot(view);
//		window.current = view;
	}
}
