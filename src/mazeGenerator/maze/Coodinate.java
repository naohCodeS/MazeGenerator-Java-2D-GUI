package mazeGenerator.maze;

/**
 * ���W�������N���X�ł�
 * @author BP20083 ��ؒ��l
 *
 */
public class Coodinate {
	private int x;
	private int y;
	
	/**
	 * @param x x���W
	 * @param y y���W
	 */
	public Coodinate(int x, int y) {
		setX(x); setY(y);
	}
	
	/**
	 * Coodinate�^�̈������󂯎����W�����킹�܂�
	 * @param coodinate �ύX������W�����ϐ�
	 */
	public void setXY(Coodinate coodinate) {this.x = coodinate.getX(); this.y = coodinate.getY();}
	/**
	 * x�̃Z�b�^�[
	 * @param x �Z�b�g����x���W
	 */
	public void setX(int x) {this.x = x;}
	/**
	 * y�̃Z�b�^�[
	 * @param y �Z�b�g����y���W
	 */
	public void setY(int y) {this.y = y;}
	/**
	 * x���W��Ԃ����\�b�h
	 * @return x���W
	 */
	public int getX() {return this.x;}
	/**
	 * y���W��Ԃ����\�b�h
	 * @return y���W
	 */
	public int getY() {return this.y;}
	/**
	 * equals���\�b�h�̒�`�ł�<br>
	 * contains���\�b�h�Ȃǂŗ��p����܂�
	 */
	public boolean equals(Object coodinate) {return this.x == ((Coodinate)coodinate).x && this.y == ((Coodinate)coodinate).y;}
	/**
	 * toString���\�b�h�̒�`�ł�<br>
	 * ��Ƀf�o�b�O�Ɏg���܂�
	 */
	public String toString() {return "("+this.x+", "+this.y+") ";}
}
