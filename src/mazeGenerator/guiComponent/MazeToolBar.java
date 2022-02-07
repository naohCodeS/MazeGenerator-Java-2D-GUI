package mazeGenerator.guiComponent;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;

/**
 * 迷路画面に表示するツールバーを設定するクラスです<br>
 * @author BP20083 鈴木直人
 */
public class MazeToolBar extends ToolBar{
	
	private static final int MIN_HEIGHT = 40;
	
	/**
	 * コンストラクタです//
	 * 引数として受け取ったボタンをツールバー内にセットします
	 * @param backButton 戻るボタン
	 */
	public MazeToolBar(Button backButton) {
		super(backButton);
		this.setOrientation(Orientation.HORIZONTAL);
		this.setMinHeight(MIN_HEIGHT);
	}

}
