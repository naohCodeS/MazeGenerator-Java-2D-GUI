package mazeGenerator.guiComponent;

import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * タイトルテキストのクラスです<br>
 * Textクラスを継承しフォントサイズやラッピング幅はあらかじめ決定されています
 * @author BP20083 鈴木直人
 *
 */
public class TitleText extends Text {
	
	private static final int FONT_SIZE = 100;
	private static final int WRAPPING_WIDTH = 1000;
	
	/**
	 * @param text タイトル
	 */
	public TitleText(String text) {
		super(text);
		this.setFont(new Font(FONT_SIZE));
		this.setWrappingWidth(WRAPPING_WIDTH);
		this.setTextAlignment(TextAlignment.CENTER);
	}
}
