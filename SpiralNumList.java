

public class SpiralNumList {

	public static void main(String[] args) {
		int m=4;
		int n=4;
		
		int[][] spiralArr = getSpiralArr(m,n);
		print2DArr(spiralArr);
	}

	private static int[][] getSpiralArr(int m, int n) {
		int topRowIdx=0;
		int bottomRowIdx=m-1;
		int leftColIdx=0;
		int rightColIdx=n-1;
		
		int[][] spiralArr =new int[m][n];
		int runner=1;
		
		while(leftColIdx<=rightColIdx && topRowIdx<=bottomRowIdx) {
			for(int i=leftColIdx;i<=rightColIdx;i++) {
				spiralArr[topRowIdx][i]=runner++;
			}
			topRowIdx++;
			
			for(int i=topRowIdx;i<=bottomRowIdx;i++) {
				spiralArr[i][rightColIdx]=runner++;
			}
			rightColIdx--;
			
			if((topRowIdx<=bottomRowIdx)) {
				for(int i=rightColIdx;i>=leftColIdx;i--) {
					spiralArr[bottomRowIdx][i]=runner++;
				}
				bottomRowIdx--;
			}
				
			if(leftColIdx<=rightColIdx)
			{
				for(int i=bottomRowIdx;i>=topRowIdx;i--) {
					spiralArr[i][leftColIdx]=runner++;
				}
				leftColIdx++;
			}	
		}
		return spiralArr;
		
	}
	
	private static void print2DArr(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("%4s",arr[i][j]);
			}
			System.out.println();
		}
	}

}
