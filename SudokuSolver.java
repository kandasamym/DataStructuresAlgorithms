public class SudokuSolver {

	public static void main(String[] args) {
		int[][] grid=getSudokuGrid();
		System.out.println("####### Sudoku board ######");
		printGrid(grid);
		boolean isSolved = solveSudoku(grid, 0, 0);
		if(isSolved) {
			System.out.println("\n####### Solved ######");
			printGrid(grid);
		}
		else {
			System.out.println("\n####### Not Solved ######");
		}

	}
	
	public static boolean solveSudoku(int[][] grid, int row, int col){
		if(col==grid[row].length) {
			row+=1;
			col=0;
		}
		
		if(row==grid.length) return true;
		
		
		if(grid[row][col]!=0) {
			return solveSudoku(grid, row, col+1);
		}
		
		for(int possibleNum=1;possibleNum<=grid.length;possibleNum++) {
			// checking all the possibility from 1 to size
			if(checkValidNum(grid, row, col, possibleNum)) {
				grid[row][col]=possibleNum;
				boolean isSolved = solveSudoku(grid, row, col+1);
				if(isSolved) return true;
				grid[row][col]=0;
			}
		}
		
		return false;
		
	}
	
	public static boolean checkValidNum(int[][] grid, int row,int col, int num) {
		//column check
		for(int c=0;c<col;c++) {
			if(grid[row][c]==num) return false;
		}
		//row check
		for(int r=0;r<row;r++) {
			if(grid[r][col]==num) return false;
		}
		// sub grid check
		int subGridSize=(int)Math.sqrt(grid.length);
		int subGridStartRow=(row/subGridSize)*subGridSize;
		int subGridStartCol=(col/subGridSize)*subGridSize;
		
		for(int r=subGridStartRow;r<subGridStartRow+subGridSize;r++) {
			for(int c=subGridStartCol;c<subGridStartCol+subGridSize;c++) {
				if(grid[r][c]==num) return false;
			}
		}
		
		return true;
	}
	
	public static void printGrid(int[][] grid) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] getSudokuGrid() {
		int[][] grid = { 
							 {3, 0, 6, 5, 0, 8, 4, 0, 0}, 
					         {5, 2, 0, 0, 0, 0, 0, 0, 0}, 
					         {0, 8, 7, 0, 0, 0, 0, 3, 1}, 
					         {0, 0, 3, 0, 1, 0, 0, 8, 0}, 
					         {9, 0, 0, 8, 6, 3, 0, 0, 5}, 
					         {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
					         {1, 3, 0, 0, 0, 0, 2, 5, 0}, 
					         {0, 0, 0, 0, 0, 0, 0, 7, 4}, 
					         {0, 0, 5, 2, 0, 6, 3, 0, 0} 
					   };
		return grid;
	}
}
