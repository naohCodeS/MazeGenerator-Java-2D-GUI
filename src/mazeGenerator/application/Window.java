package mazeGenerator.application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import mazeGenerator.view.ViewFrame;

/**
 * �E�B���h�E�̐�����s���N���X�ł�<br>
 * �������A��ʂ̑J�ڂ��������܂�
 * @author naohS
 */
public class Window {

	private static final Window window = new Window();
	private Stage wnd;
	private Scene scene;
	private boolean isInit;

	//�O������̃A�N�Z�X�͕K�v�Ȃ�
	private Window() {}

	/**
	 * �N���X�̏��������s���܂�
	 * @param stage Stage�N���X�̃C���X�^���X
	 * @param width ��ʂ̕�
	 * @param height ��ʂ̍���
	 * @param initView �ŏ��ɕ\������V�[��
	 */
	public static synchronized void init(Stage stage, double width, double height, ViewFrame initView) {
		if ( window.isInit ) throw new RuntimeException("���ɏ���������Ă��܂��B");
		window.scene = new Scene(initView, width, height);
		stage.setResizable(false);
		stage.setScene(window.scene);
		window.wnd = stage;
		window.isInit = true;
	}
	
	/**
	 * ��ʕ\�����s�����\�b�h�ł�
	 */
	public static synchronized void show() {
		if(!window.wnd.isShowing()) window.wnd.show();
	}
	
	/**
	 * ��ʂ̑J�ڂ��s���܂�
	 * @param view �J�ڐ��Scene�N���X�C���X�^���X
	 */
	public static void change(ViewFrame view) {
		window.scene.setRoot(view);
	}
}
