package mazeGenerator.guiComponent;

import javafx.scene.paint.Color;

/**
 * 迷路内のスタートのGUIです<br>
 * BlockGUIを継承します
 * @author naohS
 *
 */
public class StartGUI extends BlockGUI{
	
	private int ARC_WIDTH = 20;
	private int ARC_HEIGHT = 20;

	/**
	 * @param height 高さ
	 * @param width 幅
	 */
	public StartGUI(double height, double width) {
		super(height, width);
		this.setFill(Color.GREEN);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}
	
}
