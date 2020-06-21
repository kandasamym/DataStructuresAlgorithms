
public class HeapTest {

	public static void main(String[] args) {
		int[] arr=new int[]{-8,2,3,5,-2,-1-1,6,1,8,9,0,0,0};
		int rightIdx=arr.length-1;
		while(rightIdx>0)
		{
			perculateUp(arr,rightIdx);
			rightIdx--;
		}
		rightIdx=arr.length-1;
		while(rightIdx>0)
		{
			System.out.println(getMin(arr));
			arr[0] = arr[rightIdx];
			perculateDown(arr,0,rightIdx);
			rightIdx--;
		}
		

	}
	public static void perculateUp(int[] arr, int index) {
		if(index<=0) {
			return;
		}
		int parentIdx = (index-1)/2;
		if(arr[parentIdx]>arr[index]) {
			int temp = arr[parentIdx];
			arr[parentIdx] = arr[index];
			arr[index] = temp;
			perculateUp(arr, parentIdx);
		}
	}
	
	public static void perculateDown(int[] arr, int index, int rightMostIdx) {
		if(index>= rightMostIdx) {
			return;
		}
		int leftIdx = 2*index+1;
		int rightIdx = 2*index+2;
		
		if(leftIdx<rightMostIdx && arr[leftIdx]<arr[rightIdx] && arr[leftIdx]<arr[index]) {
			int temp = arr[leftIdx];
			arr[leftIdx] = arr[index];
			arr[index] = temp;
			perculateDown(arr, leftIdx,rightMostIdx);
		}
		else if(rightIdx<rightMostIdx && arr[rightIdx]<arr[index]) {
			int temp = arr[rightIdx];
			arr[rightIdx] = arr[index];
			arr[index] = temp;
			perculateDown(arr, rightIdx,rightMostIdx);
		}
			
	}
	
	public static int getMin(int[] arr) {
		if(arr.length==0) {
			return -1;
		}
		return arr[0];
	}
	
}
