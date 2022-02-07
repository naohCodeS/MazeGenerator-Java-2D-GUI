package mazeGenerator.guiComponent;

import javafx.scene.paint.Color;

/**
 * �S�[����GUI����������N���X�ŁABlockGUI���p�����܂�
 * @author BP20083 ��ؒ��l
 */
public class GoalGUI extends BlockGUI{
	
	private int ARC_WIDTH = 20;
	private int ARC_HEIGHT = 20;

	/**
	 * �R���X�g���N�^//
	 * �����ƕ��͕K�������Ŏ󂯎��܂�
	 * @param height �S�[����GUI�̍���
	 * @param width �S�[����GUI�̕�
	 */
	public GoalGUI(double height, double width) {
		super(height, width);
		this.setFill(Color.AQUA);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}

}
