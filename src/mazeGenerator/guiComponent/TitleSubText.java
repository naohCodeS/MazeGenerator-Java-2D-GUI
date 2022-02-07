package mazeGenerator.guiComponent;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * �^�C�g����ʂɃ^�C�g���ł͂Ȃ������Ƃ��ĕ\������鎞�ɃC���X�^���X������N���X�ł�<br>
 * Text�N���X���p�����A���炩���߃t�H���g�T�C�Y�����肵�Ă���܂��B
 * @author BP20083 ��ؒ��l
 *
 */
public class TitleSubText extends Text{
	
	private static final int FONT_SIZE = 20;
	
	/**
	 * @param text �\������e�L�X�g
	 */
	public TitleSubText(String text) {
		super(text);
		this.setFont(new Font(FONT_SIZE));
	}
}
