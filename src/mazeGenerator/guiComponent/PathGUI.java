package mazeGenerator.guiComponent;

import javafx.scene.paint.Color;

/**
 * 通路のGUIを実装するクラスです。<br>
 * BlockGUIを継承します
 * @author naohS
 */
public class PathGUI extends BlockGUI{
	
	private int ARC_WIDTH = 0;
	private int ARC_HEIGHT = 0;

	/**
	 * コンストラクタです<br>
	 * @param height 高さ
	 * @param width 幅
	 */
	public PathGUI(double height, double width) {
		super(height+1, width+1);
		this.setFill(Color.WHITE);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}

}
