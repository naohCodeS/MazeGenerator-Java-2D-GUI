package mazeGenerator.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import mazeGenerator.application.Window;
import mazeGenerator.guiComponent.BlockGUI;
import mazeGenerator.guiComponent.GoalGUI;
import mazeGenerator.guiComponent.MazeSideBox;
import mazeGenerator.guiComponent.MazeToolBar;
import mazeGenerator.guiComponent.PathGUI;
import mazeGenerator.guiComponent.ShortestPathGUI;
import mazeGenerator.guiComponent.StartGUI;
import mazeGenerator.guiComponent.WallGUI;
import mazeGenerator.maze.BlockType;
import mazeGenerator.maze.Maze;

/**
 * ���H�\����ʂ̃N���X�ł�<br>
 * VierFrame�N���X���p�����܂�
 * @author naohS
 */
public class MazeView extends ViewFrame{
	
	private int height;
	private int width;
	private Maze maze;
	private double wallWidth;
	private double wallHeight;
	private AnchorPane mazeLayout;
	private static final double MAZE_PREF_HEIGHT = 500;
	private static final double MAZE_PREF_WIDTH = 500;
	private boolean showShortestPath = false;
	
	/**
	 * ��ʂ̏��������s���܂�
	 * @param height ���H�̏c�u���b�N��
	 * @param width ���H�̉��u���b�N��
	 */
	public MazeView(int height, int width) {
		this.height = height; this.width = width;
		assert this.height > 5 && this.width > 5 && this.height % 2 == 1 && this.width % 2 == 1;
		maze = new Maze(height, width);
		
		mazeLayout = new AnchorPane();
		mazeLayout.setPrefSize(MAZE_PREF_HEIGHT,MAZE_PREF_WIDTH);
		
		wallWidth = MAZE_PREF_WIDTH/width;
		wallHeight = MAZE_PREF_HEIGHT/height;
		
		
		
		BorderPane scene = new BorderPane();
		
		MazeSideBox leftBox = this.setLeftBox();
		MazeSideBox rightBox = this.setRightBox();
		
		this.setMazeGUI();
		
		Button backButton = new Button("�߂�");
		backButton.setOnAction(event -> {
			Window.change(new TitleView());
		});
		
		MazeToolBar toolBar = new MazeToolBar(backButton);
		
		scene.setTop(toolBar);
		scene.setLeft(leftBox);
		scene.setRight(rightBox);
		scene.setCenter(mazeLayout);
		
		BorderPane.setMargin(toolBar, new Insets(0, 0, 10, 0));
		
		this.getChildren().add(scene);
	}
	
	private MazeSideBox setRightBox() {
		MazeSideBox rightBox = new MazeSideBox();
		rightBox.setAlignment(Pos.CENTER);

		Button showShortestPathButton = new Button("�ŒZ�o�H��\������");
		showShortestPathButton.setPrefHeight(50);
		showShortestPathButton.setOnAction(event -> {
			showShortestPath = !showShortestPath;
			this.setMazeGUI();
		});
		rightBox.getChildren().addAll(showShortestPathButton);
		return rightBox;
	}
	
	private MazeSideBox setLeftBox() {
		MazeSideBox leftBox = new MazeSideBox(20);
		leftBox.setAlignment(Pos.CENTER);
		VBox leftBoxComp = new VBox(20);
		leftBoxComp.setAlignment(null);
		HBox wallInfo = new HBox();
		HBox startInfo = new HBox();
		HBox goalInfo = new HBox();
		HBox shortestPathInfo = new HBox();
		int markSize = 20;
		wallInfo.getChildren().addAll(new WallGUI(markSize, markSize), new Text(" : ��"));
		startInfo.getChildren().addAll(new StartGUI(markSize, markSize), new Text(" : �X�^�[�g"));
		goalInfo.getChildren().addAll(new GoalGUI(markSize, markSize), new Text(" : �S�[��"));
		shortestPathInfo.getChildren().addAll(new ShortestPathGUI(markSize, markSize), new Text(" : �ŒZ�o�H"));

		leftBoxComp.getChildren().addAll(wallInfo, startInfo, goalInfo, shortestPathInfo);
		leftBox.getChildren().add(leftBoxComp);
		leftBox.setMargin(leftBoxComp, new Insets(0, 0, 0, 20));
		
		return leftBox;
	}
	
	
	/**
	 * ���H��GUI�Ƃ��ĉ�ʂɕ`�悷�郁�\�b�h�ł��B
	 */
	public void setMazeGUI() {
		for(int i=0; i<height; i++) {
			for(int j=0; j<width; j++) {
				BlockGUI block = null;
				if     (maze.maze[i][j].getBlockType() == BlockType.PATH)  block = new PathGUI(wallHeight, wallWidth);
				else if(maze.maze[i][j].getBlockType() == BlockType.WALL)  block = new WallGUI(wallHeight, wallWidth);
				else if(maze.maze[i][j].getBlockType() == BlockType.START) block = new StartGUI(wallHeight, wallWidth);
				else if(maze.maze[i][j].getBlockType() == BlockType.GOAL)  block = new GoalGUI(wallHeight, wallWidth);
				else if(maze.maze[i][j].getBlockType() == BlockType.SHORTEST_PATH) 
					block = (showShortestPath)?new ShortestPathGUI(wallHeight, wallWidth):new PathGUI(wallHeight, wallWidth);
				block.setX(j*wallWidth);
				block.setY(i*wallHeight);
				mazeLayout.getChildren().add(block);
			}
		}
	}
}
