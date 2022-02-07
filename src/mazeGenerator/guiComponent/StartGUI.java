package mazeGenerator.guiComponent;

import javafx.scene.paint.Color;

/**
 * ���H���̃X�^�[�g��GUI�ł�<br>
 * BlockGUI���p�����܂�
 * @author naohS
 *
 */
public class StartGUI extends BlockGUI{
	
	private int ARC_WIDTH = 20;
	private int ARC_HEIGHT = 20;

	/**
	 * @param height ����
	 * @param width ��
	 */
	public StartGUI(double height, double width) {
		super(height, width);
		this.setFill(Color.GREEN);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}
	
}
