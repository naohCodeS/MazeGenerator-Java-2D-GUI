package mazeGenerator.guiComponent;

import javafx.scene.paint.Color;

/**
 * 最短経路のGUIを実装するクラスです<br>
 * BlockGUIを継承します
 * @author naohS
 */
public class ShortestPathGUI extends BlockGUI{
	
	private int ARC_WIDTH = 20;
	private int ARC_HEIGHT = 20;
	
	/**
	 * コンストラクタです
	 * @param height 高さ
	 * @param width 幅
	 */
	public ShortestPathGUI(double height, double width) {
		super(height, width);
		this.setFill(Color.BLUE);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}
}
