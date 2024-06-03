
import java.util.Random;
import java.util.Scanner;
public class Maze {
//	private static Maze instance;

	static UI ui;
	
	Maze(UI ui){
		this.ui=ui;
     //	ui.setDisableUI();
     	
	}
	

	public Location mazeGame(){
		
            String[][] maze = generateMaze(5);
            int currentRow = 1;
            int currentCol = 1;

            ui.print("Oh no you seem to be trapped in a maze! Try finding your way to the door. You are the Queen '️️️♛' try navigating your way to find the door'' ");
            displayMaze(maze, currentRow, currentCol);

            while (true) {
               ui.print("Enter 'up', 'down', 'left', or 'right' to move: ");
                String input = ui.input();

                int newRow = currentRow;
                int newCol = currentCol;

                if (input.equals("up")) {
                    newRow--;
                } else if (input.equals("down")) {
                    newRow++;
                } else if (input.equals("left")) {
                    newCol--;
                } else if (input.equals("right")) {
                    newCol++;
                }

                if (newRow >= 0 && newRow < maze.length &&
                    newCol >= 0 && newCol < maze[0].length &&
                    maze[newRow][newCol] != "⤬") {
                    currentRow = newRow;
                    currentCol = newCol;
                }

                if (currentRow == maze.length - 2 && currentCol == maze[0].length - 2) {
                    ui.print("Congratulations, go west to find the secrataries office!");//you have found
                    return TownHall.getInstance(ui);
                    
                }

                displayMaze(maze, currentRow, currentCol);
            }
            
        }
		
	

	private static String[][] generateMaze(int size) {
		Random random = new Random();
		String[][] maze = new String[size][size];

		// Fill the maze with walls
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				maze[row][col] = "⤬";
			}
		}

		// Create a starting cell and carve a path from it
		int startRow = random.nextInt(size - 2) + 1;
		int startCol = random.nextInt(size - 2) + 1;
		maze[startRow][startCol] = " ";
		carvePath(startRow, startCol, maze);

		// Add a goal at the bottom right corner
		maze[size - 2][size - 2] = "◘";

		return maze;
	}

	private static void carvePath(int row, int col, String[][] maze) {
		int[] directions = {1, 2, 3, 4};
		shuffleArray(directions);

		for (int direction : directions) {
			int newRow = row;
			int newCol = col;

			if (direction == 1 && newRow > 1 && maze[newRow - 2][newCol] == "⤬") {
				maze[newRow - 1][newCol] = " ";
				maze[newRow - 2][newCol] = " ";
				carvePath(newRow - 2, newCol, maze);
			} else if (direction == 2 && newRow < maze.length - 2 && maze[newRow + 2][newCol] == "⤬") {
				maze[newRow + 1][newCol] = " ";
				maze[newRow + 2][newCol] = " ";
				carvePath(newRow + 2, newCol, maze);
			} else if (direction == 3 && newCol > 1 && maze[newRow][newCol - 2] == "⤬") {
				maze[newRow][newCol - 1] = " ";
				maze[newRow][newCol - 2] = " ";
				carvePath(newRow, newCol - 2, maze);
			} else if (direction == 4 && newCol < maze[0].length - 2 && maze[newRow][newCol + 2] == "⤬") {
				maze[newRow][newCol + 1] = " ";
				maze[newRow][newCol + 2] = " ";
				carvePath(newRow, newCol + 2, maze);
			}
		}
	}

	private static void shuffleArray(int[] array) {
		Random random = new Random();

		for (int i = array.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}

	private static void displayMaze(String[][] maze, int currentRow, int currentCol) {
		for (int row = 0; row < maze.length; row++) {
			for (int col = 0; col < maze[0].length; col++) {
				if (row == currentRow && col == currentCol) {
					ui.printsameline("♛️");
				} else {
					ui.printsameline(maze[row][col]);
				}
			}
			ui.print("");
		}
	}
}
