package mazeGenerator.maze;

/**
 * 迷路で使用されるブロックのタイプを区別するための列挙型クラスです
 * @author naohS
 *
 */
public enum BlockType {
	/**
	 * スタート
	 */
	START, 
	/**
	 * ゴール
	 */
	GOAL,
	/**
	 * 壁
	 */
	WALL,
	/**
	 * 通路
	 */
	PATH,
	/**
	 * 最短経路上にある
	 */
	SHORTEST_PATH
}
