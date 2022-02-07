package mazeGenerator.guiComponent;

import javafx.scene.paint.Color;

/**
 * ゴールのGUIを実装するクラスで、BlockGUIを継承します
 * @author BP20083 鈴木直人
 */
public class GoalGUI extends BlockGUI{
	
	private int ARC_WIDTH = 20;
	private int ARC_HEIGHT = 20;

	/**
	 * コンストラクタ//
	 * 高さと幅は必ず引数で受け取ります
	 * @param height ゴールのGUIの高さ
	 * @param width ゴールのGUIの幅
	 */
	public GoalGUI(double height, double width) {
		super(height, width);
		this.setFill(Color.AQUA);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}

}
