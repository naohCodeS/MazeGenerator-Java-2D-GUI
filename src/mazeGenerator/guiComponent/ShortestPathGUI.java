package mazeGenerator.guiComponent;

import javafx.scene.paint.Color;

/**
 * �ŒZ�o�H��GUI����������N���X�ł�<br>
 * BlockGUI���p�����܂�
 * @author naohS
 */
public class ShortestPathGUI extends BlockGUI{
	
	private int ARC_WIDTH = 20;
	private int ARC_HEIGHT = 20;
	
	/**
	 * �R���X�g���N�^�ł�
	 * @param height ����
	 * @param width ��
	 */
	public ShortestPathGUI(double height, double width) {
		super(height, width);
		this.setFill(Color.BLUE);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}
}
