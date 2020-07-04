import java.util.Arrays;

public class MatrixMaxRectangleSum {

	public static void main(String[] args) {
		int[][] matrix=getMatrx();
		int[] maxSumRectanglePoints;
		
		//Time complexity O(row^3*col^3), space complexity O(1)
     	maxSumRectanglePoints=getMaxSumRectangleBruteForce(matrix);
		printReactangleMatrix(matrix,maxSumRectanglePoints[0],maxSumRectanglePoints[1],maxSumRectanglePoints[2],maxSumRectanglePoints[3]);

		//Time complexity O(col*col*row), space complexity O(row)
		maxSumRectanglePoints=getMaxRectangleSum(matrix);
		printReactangleMatrix(matrix,maxSumRectanglePoints[0],maxSumRectanglePoints[1],maxSumRectanglePoints[2],maxSumRectanglePoints[3]);

	}
	
	private static int[] getMaxRectangleSum(int[][] matrix) {
		int maxSum=Integer.MIN_VALUE;
		int[] maxSumRectanglePoints=new int[4]; // to store the rectangle points top left and bottom right
		int[] rowSum=new int[matrix.length];
		
		for(int leftCol=0;leftCol<matrix[0].length;leftCol++) {
			for(int rightCol=leftCol;rightCol<matrix[0].length;rightCol++) {
				
				for(int row=0;row<matrix.length;row++) {
					rowSum[row]+=matrix[row][rightCol];
				}
				int[] currentMaxSumRows = getMaxSum1dArrKadaneAlgo(rowSum);
				int currentMaxSum=currentMaxSumRows[0];
				if( currentMaxSum>maxSum) {
					maxSum=currentMaxSum;
					maxSumRectanglePoints[0]=currentMaxSumRows[1]; //top row
					maxSumRectanglePoints[1]=leftCol;
					maxSumRectanglePoints[2]=currentMaxSumRows[2]; //bottom row
					maxSumRectanglePoints[3]=rightCol;
				}
			}
			// clear the array
			Arrays.fill(rowSum, 0);
		}
		System.out.println("max sum: "+ maxSum);
		return maxSumRectanglePoints;
	}
	
	static int[] getMaxSum1dArrKadaneAlgo(int[] arr) {
		int maxSum=Integer.MIN_VALUE;
		int currentSum=0;
		int startIdx=0;
		int maxStartIdx=0;
		int maxEndIdx=0;
		for(int i=0;i<arr.length;i++) {
			currentSum+=arr[i];
			
			if(currentSum>maxSum) {
				maxSum=currentSum;
				maxStartIdx=startIdx;
				maxEndIdx=i;
			}
			if(currentSum<0) {
				startIdx=i+1;
				currentSum=0;
			}
		}
		return new int[] {maxSum,maxStartIdx,maxEndIdx};
	}

	static int[] getMaxSumRectangleBruteForce(int[][] matrix) {
		int maxSum=Integer.MIN_VALUE;
		int[] maxSumRectanglePoints=new int[4]; // to store the rectangle points top left and bottom right
		for(int topRow=0;topRow<matrix.length;topRow++) {
			for(int leftCol=0;leftCol<matrix[topRow].length;leftCol++) {
				
				for(int bottomRow=topRow;bottomRow<matrix.length;bottomRow++) {
					for(int rightCol=leftCol;rightCol<matrix[bottomRow].length;rightCol++) {
						
						int sum = getSubMatrixSum(matrix, topRow, leftCol, bottomRow, rightCol);
						
						if(sum>maxSum) {
							maxSum=sum;
							maxSumRectanglePoints[0]=topRow;
							maxSumRectanglePoints[1]=leftCol;
							maxSumRectanglePoints[2]=bottomRow;
							maxSumRectanglePoints[3]=rightCol;
						}
					}
				}
			}
		}
		System.out.println("max sum: "+ maxSum);
		return maxSumRectanglePoints;
	}

	private static int getSubMatrixSum(int[][] matrix, int topRow, int leftCol, int bottomRow, int rightCol) {
		int sum=0;
		for(int row=topRow;row<=bottomRow;row++) {
			for(int col=leftCol;col<=rightCol;col++) {
				sum+=matrix[row][col];
			}
		}
		return sum;
	}

	private static int[][] getMatrx() {
		int[][] matrix= new int[][]{
									{6, -5, -7, 4, -4},
									{-9, 3, -6, 5, 2},
									{-10, 4, 7, -6, 3},
									{-8, 9, -3, 3, -7}
								};
		return matrix;
	}
	
	private static void printReactangleMatrix(int[][] arr, int topRow,int leftCol, int bottomRow, int rightCol) {
		for(int row=topRow;row<=bottomRow;row++) {
			for(int col=leftCol;col<=rightCol;col++) {
				System.out.printf("%4s",arr[row][col]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
