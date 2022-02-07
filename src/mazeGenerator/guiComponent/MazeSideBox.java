package mazeGenerator.guiComponent;

import javafx.scene.layout.VBox;

/**
 * ���H��ʂ̍��E�ɐ�������N���X�ł�
 * @author BP20083 ��ؒ��l
 *
 */
public class MazeSideBox extends VBox{
	
	private static final int BOX_WIDTH = 250;
	private static final int BOX_HEIGHT = 500;
	
	/**
	 * �������Ȃ��ꍇ�̃R���X�g���N�^�ł�//
	 */
	public MazeSideBox() {
		super();
		this.setPrefSize(BOX_WIDTH, BOX_HEIGHT);
	}
	
	/**
	 * double�^�������ɂƂ�R���X�g���N�^�ł�//
	 * �㉺���E�̃X�y�[�V���O��ݒ肵�܂�
	 * @param space �X�y�[�X
	 */
	public MazeSideBox(double space) {
		super(space);
		this.setPrefSize(BOX_WIDTH, BOX_HEIGHT);
	}
}
