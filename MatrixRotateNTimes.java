
public class MatrixRotateNTimes {

	public static void main(String[] args) {
		int matrixSize=5;
		int[][] squareMatrix = getMatrix(matrixSize);
		System.out.println("Original matrix");
		print2DArr(squareMatrix);
		
		int rightRotateTime;
		rightRotateTime=22;
		
//		// left rotation
//		int leftRotateTime=3;
//		leftRotateTime=leftRotateTime% 4;
//		rightRotateTime= 4-leftRotateTime; //complement
		
		rightRotateTime=rightRotateTime % 4;
		
		int rightRotateTimeCopy=rightRotateTime;
		while(rightRotateTime>0) {
			rightRotate(squareMatrix);
			rightRotateTime--;
		}
		
		System.out.println("Matrix after "+rightRotateTimeCopy+" times right rotation" );
		print2DArr(squareMatrix);
		
	}
	
	private static void rightRotate(int[][] squareMatrix) {
		int len=squareMatrix.length;
		int topRowIdx=0;
		int bottomRowIdx=len-1;
		int leftColIdx=0;
		int rightColIdx=len-1;
		
		while(leftColIdx<rightColIdx) {
			
			int br=bottomRowIdx;
			int rc=rightColIdx;
			int tr=topRowIdx;
			int lc=leftColIdx;
			
			while(lc<rightColIdx) {
				int temp = squareMatrix[topRowIdx][lc];
				squareMatrix[topRowIdx][lc]= squareMatrix[br][leftColIdx];
				squareMatrix[br][leftColIdx]= squareMatrix[bottomRowIdx][rc];
				squareMatrix[bottomRowIdx][rc] = squareMatrix[tr][rightColIdx];
				squareMatrix[tr][rightColIdx] = temp;
				lc++;
				tr++;
				rc--;
				br--;
			}
			leftColIdx++;
			topRowIdx++;
			rightColIdx--;
			bottomRowIdx--;
		}
	}
	
	private static int[][] getMatrix(int n) {
		int[][] matrix =  new int[n][n];
		int runner=1;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				matrix[i][j]=runner++;
			}
		}
		return matrix;
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
