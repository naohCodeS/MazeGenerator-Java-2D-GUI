package mazeGenerator.guiComponent;

import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * タイトル画面にタイトルではない文字として表示される時にインスタンス化するクラスです<br>
 * Textクラスを継承し、あらかじめフォントサイズを決定してあります。
 * @author BP20083 鈴木直人
 *
 */
public class TitleSubText extends Text{
	
	private static final int FONT_SIZE = 20;
	
	/**
	 * @param text 表示するテキスト
	 */
	public TitleSubText(String text) {
		super(text);
		this.setFont(new Font(FONT_SIZE));
	}
}
