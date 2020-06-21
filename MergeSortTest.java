import java.util.Arrays;


public class MergeSortTest {
	
	public static void main(String[] args) {
		int[] arr=new int[] {3,4,1,-5,88,-99,-8,0,0,1,2};
		mergeSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));

	}

	public static void mergeSort(int[] arr,int leftIdx,int rightIdx) {
		if(leftIdx>=rightIdx)
			return;
		int midIdx = (leftIdx+rightIdx)/2;
		mergeSort(arr, leftIdx, midIdx);
		mergeSort(arr, midIdx+1, rightIdx);
		merge(arr,leftIdx,midIdx,rightIdx);
	}
	public static void merge(int[] arr,int leftIdx,int midIdx,int rightIdx) {
		int[] aux=new int[rightIdx-leftIdx+1];
		for(int i=leftIdx;i<=rightIdx;i++) {
			aux[i-leftIdx]=arr[i];
		}
		int auxMidIdx=midIdx-leftIdx;
		int auxRighIdx=rightIdx-leftIdx;
		int i=0;
		int j=auxMidIdx+1;
		int k=leftIdx;
		while(i<=auxMidIdx && j<=auxRighIdx) {
			if(aux[i]<=aux[j]) {
				arr[k++]=aux[i++];
			}
			else {
				arr[k++]=aux[j++];
			}
		}
		while(i<=auxMidIdx) {
			arr[k++]=aux[i++];
		}
	}
}
