package mazeGenerator.guiComponent;

/**
 * ï«ÇÃGUIÇÃÉNÉâÉXÇ≈Ç∑<br>
 * BlockGUIÇåpè≥ÇµÇ‹Ç∑
 * @author naohS
 *
 */
public class WallGUI extends BlockGUI{
	
	private int ARC_WIDTH = 0;
	private int ARC_HEIGHT = 0;
	
	/**
	 * @param height ï«ÇÃçÇÇ≥
	 * @param width ï«ÇÃïù
	 */
	public WallGUI(double height, double width) {
		super(height, width);
		this.setArcHeight(ARC_HEIGHT);
		this.setArcWidth(ARC_WIDTH);
	}
}
