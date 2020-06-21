import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] arr=new int[] {1000,10000,4,5,2,7,8,9,1,0,-5,0,0,100,-100,50,6};
		int len=arr.length;
		int firstNLIdx=(len-1)-1/2;
		for(int i=firstNLIdx;i>=0;i--){
			perculateDownItr(arr, i, len);
		}
		
		for(int i=len-1;i>=0;i--) {
			swap(arr,0,i);
			perculateDownItr(arr, 0, i);
		}
		System.out.println(Arrays.toString(arr));

	}
	
	public static void perculateDown(int[] arr,int i, int n) {
		int maxIdx = i;
		int leftIdx=i*2+1;
		int rightIdx=i*2+2;
		if(leftIdx<n && arr[leftIdx]>arr[maxIdx]) {
			maxIdx=leftIdx;
		}
		if(rightIdx<n && arr[rightIdx]>arr[maxIdx]) {
			maxIdx=rightIdx;
		}
		if(maxIdx!=i) {
			swap(arr,maxIdx,i);
			perculateDown(arr, maxIdx, n);
		}
	}
	
	public static void perculateDownItr(int[] arr,int i, int n) {
		while(i<n) {
			int maxIdx = i;
			int leftIdx=i*2+1;
			int rightIdx=i*2+2;
			if(leftIdx<n && arr[leftIdx]>arr[maxIdx]) {
				maxIdx=leftIdx;
			}
			if(rightIdx<n && arr[rightIdx]>arr[maxIdx]) {
				maxIdx=rightIdx;
			}
			if(maxIdx!=i) {
				swap(arr,maxIdx,i);
				i=maxIdx;
			}
			else break;
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
