package mazepaths;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node {
	private int x;
	private int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.x + "-" + this.y;
	}
}

public class MazePaths {

	// Initialize a string direction which represents all
	// the directions.
	static String direction = "DLRU";

	// Arrays to represent change in rows and columns
	static int[] dr = { 1, 0, 0, -1 };
	static int[] dc = { 0, -1, 1, 0 };

	// Function to check if cell(row, col) is inside the
	// maze and unblocked
	static boolean isValid(int row, int col, int n, int m, char[][] maze) {
		return row >= 0 && col >= 0 && row < n && col < m && maze[row][col] == '.';
	}

	// Function to get all valid paths
	static void findPath(int row, int col, char[][] maze, int n, int m, ArrayList<String> ans, Stack<Node> currentNode,
			StringBuilder currentPath) {
		// If we reach the bottom right cell of the matrix,
		// add the current path to ans and return
		if (row == n - 1 && col == m - 2) {
			ans.add(currentPath.toString());
			ans.add(currentNode.toString());
			return;
		}
		// Mark the current cell as blocked
		maze[row][col] = '#';

		for (int i = 0; i < 4; i++) {
			// Find the next row based on the current row
			// (row) and the dr[] array
			int nextrow = row + dr[i];
			// Find the next column based on the current
			// column (col) and the dc[] array
			int nextcol = col + dc[i];

			// Check if the next cell is valid or not
			if (isValid(nextrow, nextcol, n, m, maze)) {
				currentPath.append(direction.charAt(i));
				currentNode.add(new Node(nextcol, nextrow));
				// Recursively call the FindPath function
				// for the next cell
				findPath(nextrow, nextcol, maze, n, m, ans, currentNode, currentPath);
				// Remove the last direction when
				// backtracking
				currentPath.deleteCharAt(currentPath.length() - 1);
				currentNode.pop();
			}
		}
		// Mark the current cell as unblocked
		maze[row][col] = '.';
	}

	public static void main(String[] args) {

		char[][] maze0 = { { '#', '.', '#', '#', '#', '#', '#' }, 
				{ '#', '.', '#', '#', '#', '#', '#' },
				{ '#', '.', '#', '#', '#', '#', '#' }, 
				{ '#', '.', '.', '.', '.', '.', '#' },
				{ '#', '.', '#', '#', '#', '.', '#' }, 
				{ '#', '.', '.', '.', '.', '.', '#' },
				{ '#', '#', '#', '#', '#', '.', '#' } };
		
		char[][] maze = {{'#', '.', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
				{ '#', '.', '.', '.', '#', '.', '.', '.', '.', '.','.', '.', '.', '.', '.', '.', '#'},
				{'#', '.', '#', '#', '#', '.','#', '#', '#','#', '#', '.', '#','.', '#','.', '#' },
				{'#', '.', '.', '.', '.', '.','.', '.', '.', '.', '.', '.','#', '.', '.', '.','#'},
				{'#', '#', '#', '#', '#','#', '#', '#', '#', '#','#', '#', '#', '#', '#','.', '#'}};
				

		int n = maze.length;
		int m = maze[0].length;
		// List to store all the valid paths
		ArrayList<String> result = new ArrayList<>();
		// Store current path
		StringBuilder currentPath = new StringBuilder();
		Stack<Node> currentNode = new Stack<>();

		// if (maze[0][1] != 0 && maze[n - 1][n - 1] != 0) {
		// Function call to get all valid paths
		findPath(0, 1, maze, n, m, result, currentNode, currentPath);
		// }

		if (result.size() == 0)
			System.out.println(-1);
		else
			for (String path : result)
				System.out.println(path + " ");
		System.out.println();
	}
}
