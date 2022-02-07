package mazeGenerator.guiComponent;

import javafx.scene.control.TextField;

/**
 * �^�C�g���ɕ\������e�L�X�g�t�B�[���h�̃N���X�ł�
 * @author naohS
 *
 */
public class TitleTextField extends TextField{
	
	private static final int FIELD_HEIGHT = 20;
	
	/**
	 * 
	 * @param promptText �e�L�X�g�t�B�[���h�ɓ��͂����O�ɕ\������e�L�X�g
	 */
	public TitleTextField(String promptText) {
		super();
		this.setPromptText(promptText);
		this.setHeight(FIELD_HEIGHT);
	}

}
