package mazeGenerator.guiComponent;

import javafx.scene.shape.Rectangle;

/**
 * ���H���`������R���|�[�l���g�i�ǁA�X�^�[�g�A�S�[���Ȃǁj�̊�{�I�Ȍ`���`����N���X�ł�<br>
 * �R���|�[�l���g�͂��̃N���X���p�����C���X�^���X������܂�
 * @author naohS
 */
public class BlockGUI extends Rectangle{
	private double width;
	private double height;
	private int ARC_WIDTH = 20;
	private int ARC_HEIGHT = 20;
	
	/**
	 * �R���X�g���N�^�ł�//
	 * @param height ����
	 * @param width ��
	 */
	public BlockGUI(double height, double width) {
		super();
		this.width = width;
		this.height = height;
		
		assert this.width > 0 && this.height > 0;
		
		this.setWidth(this.width);
		this.setHeight(this.height);
		
		this.setArcWidth(ARC_WIDTH);
		this.setArcHeight(ARC_HEIGHT);
	}
}
