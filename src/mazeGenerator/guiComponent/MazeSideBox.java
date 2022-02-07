package mazeGenerator.guiComponent;

import javafx.scene.layout.VBox;

/**
 * 迷路画面の左右に生成するクラスです
 * @author BP20083 鈴木直人
 *
 */
public class MazeSideBox extends VBox{
	
	private static final int BOX_WIDTH = 250;
	private static final int BOX_HEIGHT = 500;
	
	/**
	 * 引数がない場合のコンストラクタです//
	 */
	public MazeSideBox() {
		super();
		this.setPrefSize(BOX_WIDTH, BOX_HEIGHT);
	}
	
	/**
	 * double型を引数にとるコンストラクタです//
	 * 上下左右のスペーシングを設定します
	 * @param space スペース
	 */
	public MazeSideBox(double space) {
		super(space);
		this.setPrefSize(BOX_WIDTH, BOX_HEIGHT);
	}
}
