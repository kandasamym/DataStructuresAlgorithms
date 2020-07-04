import java.util.LinkedList;

public class NQueenPlacement {

	public static void main(String[] args) {
		//int n=2; // can't place queens in 2*2
		int n=4;
		int[][] board=new int[n][n];
		
		LinkedList<Integer[]> prevQueensCells=new LinkedList<Integer[]>();
		boolean isSuccess = placeNQueens(board,prevQueensCells, 0,1);
		if(isSuccess)
			print2DArr(board);
		else
			System.out.println("Not able to place "+n+" queens");
	}
	
	
	private static boolean placeNQueens(int[][] board, LinkedList<Integer[]> prevQueensCells, int row, int k) {
		if(row==board.length) {
			return true;
		}
		for(int col=0;col<board[row].length;col++) {
			if(isValidPlace(row,col,prevQueensCells)) {
				board[row][col]=k;
				prevQueensCells.add(new Integer[] {row,col});
				boolean isRecurSuccess = placeNQueens(board,prevQueensCells, row+1, k+1);
				if(isRecurSuccess) return true;
				board[row][col]=0;
				prevQueensCells.removeLast();
			}
		}
		
		return false;
	}


	private static boolean isValidPlace(int row, int col, LinkedList<Integer[]> prevQueensCells) {
		for(Integer[] queenPlace: prevQueensCells) {
			int queenRow=queenPlace[0];
			int queenCol=queenPlace[1];
			
			// horizontal and vertical attacks checking
			if(queenRow==row || queenCol==col) return false;
			
			//diagonal attacks checking (True, if horizontal and vertical distance same)
			
			int verticalDistance=Math.abs(row-queenRow);
			int horizontalDistance=Math.abs(col-queenCol);
			if(horizontalDistance==verticalDistance) return false;
			
		}
		return true;
	}


	private static void print2DArr(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("%4s",arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
