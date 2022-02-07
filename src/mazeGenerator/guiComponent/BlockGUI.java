package mazeGenerator.guiComponent;

import javafx.scene.shape.Rectangle;

/**
 * 迷路を形成するコンポーネント（壁、スタート、ゴールなど）の基本的な形を定義するクラスです<br>
 * コンポーネントはこのクラスを継承しインスタンス化されます
 * @author naohS
 */
public class BlockGUI extends Rectangle{
	private double width;
	private double height;
	private int ARC_WIDTH = 20;
	private int ARC_HEIGHT = 20;
	
	/**
	 * コンストラクタです//
	 * @param height 高さ
	 * @param width 幅
	 */
	public BlockGUI(double height, double width) {
		super();
		this.width = width;
		this.height = height;
		
		assert this.width > 0 && this.height > 0;
		
		this.setWidth(this.width);
		this.setHeight(this.height);
		
		this.setArcWidth(ARC_WIDTH);
		this.setArcHeight(ARC_HEIGHT);
	}
}
