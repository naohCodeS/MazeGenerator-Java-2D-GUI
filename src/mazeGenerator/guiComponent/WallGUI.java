package mazeGenerator.guiComponent;

/**
 * •Ç‚ÌGUI‚ÌƒNƒ‰ƒX‚Å‚·<br>
 * BlockGUI‚ğŒp³‚µ‚Ü‚·
 * @author BP20083 —é–Ø’¼l
 *
 */
public class WallGUI extends BlockGUI{
	
	private int ARC_WIDTH = 0;
	private int ARC_HEIGHT = 0;
	
	/**
	 * @param height •Ç‚Ì‚‚³
	 * @param width •Ç‚Ì•
	 */
	public WallGUI(double height, double width) {
		super(height, width);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}
}
