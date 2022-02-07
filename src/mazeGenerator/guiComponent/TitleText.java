package mazeGenerator.guiComponent;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * �^�C�g���e�L�X�g�̃N���X�ł�<br>
 * Text�N���X���p�����t�H���g�T�C�Y�⃉�b�s���O���͂��炩���ߌ��肳��Ă��܂�
 * @author BP20083 ��ؒ��l
 *
 */
public class TitleText extends Text {
	
	private static final int FONT_SIZE = 100;
	private static final int WRAPPING_WIDTH = 1000;
	
	/**
	 * @param text �^�C�g��
	 */
	public TitleText(String text) {
		super(text);
		this.setFont(new Font(FONT_SIZE));
		this.setWrappingWidth(WRAPPING_WIDTH);
		this.setTextAlignment(TextAlignment.CENTER);
	}
}
