package mazeGenerator.guiComponent;

/**
 * ĒĢGUIĢNXÅ·<br>
 * BlockGUIšp³µÜ·
 * @author BP20083 éŲ¼l
 *
 */
public class WallGUI extends BlockGUI{
	
	private int ARC_WIDTH = 0;
	private int ARC_HEIGHT = 0;
	
	/**
	 * @param height ĒĢ³
	 * @param width ĒĢ
	 */
	public WallGUI(double height, double width) {
		super(height, width);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}
}
