package mazeGenerator.guiComponent;

import javafx.scene.control.TextField;

/**
 * タイトルに表示するテキストフィールドのクラスです
 * @author BP20083 鈴木直人
 *
 */
public class TitleTextField extends TextField{
	
	private static final int FIELD_HEIGHT = 20;
	
	/**
	 * 
	 * @param promptText テキストフィールドに入力される前に表示するテキスト
	 */
	public TitleTextField(String promptText) {
		super();
		this.setPromptText(promptText);
		this.setHeight(FIELD_HEIGHT);
	}

}
