package mazeGenerator.guiComponent;

import javafx.scene.paint.Color;

/**
 * �ʘH��GUI����������N���X�ł��B<br>
 * BlockGUI���p�����܂�
 * @author naohS
 */
public class PathGUI extends BlockGUI{
	
	private int ARC_WIDTH = 0;
	private int ARC_HEIGHT = 0;

	/**
	 * �R���X�g���N�^�ł�<br>
	 * @param height ����
	 * @param width ��
	 */
	public PathGUI(double height, double width) {
		super(height+1, width+1);
		this.setFill(Color.WHITE);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}

}
