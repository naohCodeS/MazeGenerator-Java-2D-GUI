package mazeGenerator.maze;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Random;
import java.util.Stack;

/**
 * 迷路を実装するクラスです<br>
 * 迷路はBlockクラスの二次元配列であらわされます
 * @author naohS
 *
 */
public class Maze {
	
	private int height;
	private int width;
	/**
	 * 迷路本体です
	 */
	public Block[][] maze;
	private int startX = 1;
	private int startY = 1;
	private int goalX;
	private int goalY;
	private ArrayList<Coodinate> startCandidates;
	private Stack<Coodinate> currentMakingWall;
	
	/**
	 * 迷路の初期化、生成、最短経路探索まで行います
	 * @param height 縦ブロック数
	 * @param width 横ブロック数
	 */
	public Maze(int height, int width) {
		this.height = height;
		this.width = width;
		this.goalX = width - 2;
		this.goalY = height - 2;
		
		maze = new Block[height][width];
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++)
				maze[i][j] = new Block();
		currentMakingWall = new Stack<>();
		startCandidates = new ArrayList<>();
		
		this.initStartCandidates();
		
		this.mazeGenerator();
		
		this.setShortestPath();
	}
	
	/**
	 * 迷路本体（Blockクラスの二次元配列）を返すクラスです
	 * @return 迷路
	 */
	public Block[][] getMaze(){return this.maze;}
	
	private void setShortestPath() {
		Deque<Coodinate> que = new ArrayDeque<>();
		int[][] minTime = new int[this.height][this.width];
		for(int y = 0; y < this.height; y++)
			for(int x = 0; x < this.width; x++)
				minTime[y][x] = -1;
		que.add(new Coodinate(this.startX, this.startY));
		while(!que.isEmpty()) {
			Coodinate now = que.poll();
			int x = now.getX();
			int y = now.getY();
			if(y-1>=0 && minTime[y-1][x] == -1 && maze[y-1][x].getBlockType() != BlockType.WALL) {         
				que.add(new Coodinate(x, y-1));
				minTime[y-1][x] = minTime[y][x] + 1;
			}
			if(y+1<this.height && minTime[y+1][x] == -1 && maze[y+1][x].getBlockType() != BlockType.WALL) {
				que.add(new Coodinate(x, y+1));
				minTime[y+1][x] = minTime[y][x] + 1;
			}
			if(x-1>=0 && minTime[y][x-1] == -1 && maze[y][x-1].getBlockType() != BlockType.WALL)         {
				que.add(new Coodinate(x-1, y));
				minTime[y][x-1] = minTime[y][x] + 1;
			}
			if(x+1<this.width && minTime[y][x+1] == -1 && maze[y][x+1].getBlockType() != BlockType.WALL) {
				que.add(new Coodinate(x+1, y));
				minTime[y][x+1] = minTime[y][x] + 1;
			}
		}
		dfsShortestPath(minTime, new Coodinate(this.goalX, this.goalY));
	}
	
	private void dfsShortestPath(int[][] minTime, Coodinate coodinate) {
		if(coodinate.equals(new Coodinate(this.startX, this.startY))) return;
		int x = coodinate.getX();
		int y = coodinate.getY();
		if(maze[y][x].getBlockType() == BlockType.PATH) maze[y][x].setBlockType(BlockType.SHORTEST_PATH);
		if(y-1>=0&&minTime[y-1][x] == minTime[y][x]-1)               dfsShortestPath(minTime, new Coodinate(x, y-1));
		else if(y+1<this.height&&minTime[y+1][x] == minTime[y][x]-1) dfsShortestPath(minTime, new Coodinate(x, y+1));
		else if(x-1>=0&&minTime[y][x-1] == minTime[y][x]-1)          dfsShortestPath(minTime, new Coodinate(x-1, y));
		else if(x+1<this.width&&minTime[y][x+1] == minTime[y][x]-1)  dfsShortestPath(minTime, new Coodinate(x+1, y));
	}
	
	private void initStartCandidates() {
		for(int y = 1; y*2 < height-1; y++)
			for(int x = 1; x*2 < width-1; x++)
				startCandidates.add(new Coodinate(x*2, y*2));
	}
	
	private void setOuter() {
		for(int wid = 0; wid < this.width; wid++) {
			maze[0][wid].setBlockType(BlockType.WALL);
			maze[this.height-1][wid].setBlockType(BlockType.WALL);
		}
		for(int hei = 0; hei < this.height; hei++) {
			maze[hei][0].setBlockType(BlockType.WALL);
			maze[hei][this.width-1].setBlockType(BlockType.WALL);
		}
	}
	
	private Coodinate getStartingCoordinates() {
		Coodinate start = new Coodinate(-1, -1);
		while(!startCandidates.isEmpty()) {
			int index = new Random().nextInt(startCandidates.size());
			start.setXY(startCandidates.get(index));
			startCandidates.remove(index);
			if(maze[start.getY()][start.getX()].getBlockType() == BlockType.PATH) return start;
		}
		return new Coodinate(-1, -1);
	}
	
	private boolean isCurrentMakingWall(Coodinate coodinate) {
		return currentMakingWall.contains(coodinate);
	}
	
	private void setWall(Coodinate coodinate) {
		this.maze[coodinate.getY()][coodinate.getX()].setBlockType(BlockType.WALL);
		if(coodinate.getX()%2==0&&coodinate.getY()%2==0&&!currentMakingWall.contains(coodinate)) {
			currentMakingWall.push(coodinate);
		}
	}
	
//	private void debugMazeShow() {
//		for(int i=0; i<this.height; i++) {
//			for(int j=0; j<this.width; j++) {
//				if(maze[i][j].getBlockType()==BlockType.START) System.out.print("S ");
//				if(maze[i][j].getBlockType()==BlockType.GOAL) System.out.print("G ");
//				if(maze[i][j].getBlockType()==BlockType.WALL) System.out.print("Q ");
//				if(maze[i][j].getBlockType()==BlockType.PATH) System.out.print("  ");
//				if(maze[i][j].getBlockType()==BlockType.SHORTEST_PATH) System.out.print("C ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
	
	private void strechWall(Coodinate coodinate) {
		
		ArrayList<Direction> directionCandidates = new ArrayList<>();
		
		if(this.maze[coodinate.getY()-1][coodinate.getX()].getBlockType() == BlockType.PATH && !isCurrentMakingWall(new Coodinate(coodinate.getX(), coodinate.getY()-2))) directionCandidates.add(Direction.UP);
		if(this.maze[coodinate.getY()+1][coodinate.getX()].getBlockType() == BlockType.PATH && !isCurrentMakingWall(new Coodinate(coodinate.getX(), coodinate.getY()+2))) directionCandidates.add(Direction.DOWN);
		if(this.maze[coodinate.getY()][coodinate.getX()-1].getBlockType() == BlockType.PATH && !isCurrentMakingWall(new Coodinate(coodinate.getX()-2, coodinate.getY()))) directionCandidates.add(Direction.LEFT);
		if(this.maze[coodinate.getY()][coodinate.getX()+1].getBlockType() == BlockType.PATH && !isCurrentMakingWall(new Coodinate(coodinate.getX()+2, coodinate.getY()))) directionCandidates.add(Direction.RIGHT);
		
		
		if(!directionCandidates.isEmpty()) {
			this.setWall(coodinate);
			
			Direction dir = directionCandidates.get(new Random().nextInt(directionCandidates.size()));
			boolean connectedPath = false; //道につながった　＝　まだ伸ばせる
			Coodinate nextBlock = null;
			
			switch(dir) {
			case UP    :
				connectedPath = (this.maze[coodinate.getY()-2][coodinate.getX()].getBlockType() == BlockType.PATH);
				setWall(new Coodinate(coodinate.getX(), coodinate.getY()-1));
				setWall(new Coodinate(coodinate.getX(), coodinate.getY()-2));
				nextBlock = new Coodinate(coodinate.getX(), coodinate.getY()-2);
				break;
			case DOWN  :
				connectedPath = (this.maze[coodinate.getY()+2][coodinate.getX()].getBlockType() == BlockType.PATH);
				setWall(new Coodinate(coodinate.getX(), coodinate.getY()+1));
				setWall(new Coodinate(coodinate.getX(), coodinate.getY()+2));
				nextBlock = new Coodinate(coodinate.getX(), coodinate.getY()+2);
				break;
			case LEFT  :
				connectedPath = (this.maze[coodinate.getY()][coodinate.getX()-2].getBlockType() == BlockType.PATH);
				setWall(new Coodinate(coodinate.getX()-1, coodinate.getY()));
				setWall(new Coodinate(coodinate.getX()-2, coodinate.getY()));
				nextBlock = new Coodinate(coodinate.getX()-2, coodinate.getY());
				break;
			case RIGHT :
				connectedPath = (this.maze[coodinate.getY()][coodinate.getX()+2].getBlockType() == BlockType.PATH);
				setWall(new Coodinate(coodinate.getX()+1, coodinate.getY()));
				setWall(new Coodinate(coodinate.getX()+2, coodinate.getY()));
				nextBlock = new Coodinate(coodinate.getX()+2, coodinate.getY());
				break;
			}
			if(currentMakingWall.size() < 7 && connectedPath) strechWall(nextBlock);
		}
		else {
			strechWall(currentMakingWall.peek());
		}
		
	}
	
	private void mazeGenerator(){
		this.setOuter();
		maze[startY][startX].setBlockType(BlockType.START);
		maze[goalY][goalX].setBlockType(BlockType.GOAL);
		while(true) {
			Coodinate start = getStartingCoordinates();
			if(start.equals(new Coodinate(-1, -1))) break;
			setWall(start);
			strechWall(start);
			currentMakingWall.clear();
		}
	}
}
