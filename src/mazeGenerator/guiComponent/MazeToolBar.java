package mazeGenerator.guiComponent;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

/**
 * ���H��ʂɕ\������c�[���o�[��ݒ肷��N���X�ł�<br>
 * @author BP20083 ��ؒ��l
 */
public class MazeToolBar extends ToolBar{
	
	private static final int MIN_HEIGHT = 40;
	
	/**
	 * �R���X�g���N�^�ł�//
	 * �����Ƃ��Ď󂯎�����{�^�����c�[���o�[���ɃZ�b�g���܂�
	 * @param backButton �߂�{�^��
	 */
	public MazeToolBar(Button backButton) {
		super(backButton);
		this.setOrientation(Orientation.HORIZONTAL);
		this.setMinHeight(MIN_HEIGHT);
	}

}
