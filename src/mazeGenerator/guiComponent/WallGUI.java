package mazeGenerator.guiComponent;

/**
 * �ǂ�GUI�̃N���X�ł�<br>
 * BlockGUI���p�����܂�
 * @author naohS
 *
 */
public class WallGUI extends BlockGUI{
	
	private int ARC_WIDTH = 0;
	private int ARC_HEIGHT = 0;
	
	/**
	 * @param height �ǂ̍���
	 * @param width �ǂ̕�
	 */
	public WallGUI(double height, double width) {
		super(height, width);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}
}
