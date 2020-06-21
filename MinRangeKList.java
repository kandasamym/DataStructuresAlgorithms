import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinRangeKList {

	public static void main(String[] args) {
		// Assumed no empty 1d array
		Integer[][] arr=new Integer[][] {
			{4,10,15,24,26},
			{0,9,12,20}, 
			{5,18,22,30}
		};
		
		PriorityQueue<Integer[]> minHeap= new PriorityQueue<Integer[]>(10,
				new Comparator<Integer[]>(){
					public int compare(Integer[] a, Integer[] b) {
						return a[0]-b[0];
					}
				});
		
		int max =initialHeapLoadAndGetMax(arr, minHeap);
		int minRangeLen = Integer.MAX_VALUE;
		int[] minRange = new int[2];
		
		while(true) { 
			Integer[] currMin = minHeap.poll();
			Integer currMinValue = currMin[0];
			Integer currMinIdx= currMin[1];
			Integer currMinArrIdx=currMin[2];
			Integer currRange = max - currMinValue+1;
			
			if(currRange<minRangeLen) {
				minRangeLen=currRange;
				minRange[0]=currMinValue;
				minRange[1]=max;
			}
			
			if(currMinIdx+1< arr[currMinArrIdx].length) {
				max= insertHeapAndGetMax(arr, minHeap, currMinIdx+1, currMinArrIdx, max);
			}
			// if at least one array completely traversed, break the loop
			else break;
			
		}
		
		System.out.println(Arrays.toString(minRange));
	}
	
	public static int initialHeapLoadAndGetMax(Integer[][] arr, PriorityQueue<Integer[]> minHeap) {
		
//		load the heap with first element of every array and return max
		Integer max=Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			max= insertHeapAndGetMax(arr, minHeap, 0, i, max);
		}
		return max;
	}
	
	public static int insertHeapAndGetMax(Integer[][] arr, PriorityQueue<Integer[]> minHeap, 
			int idx, int arrIdx, int max) {
		Integer[] currArr=new Integer[] {arr[arrIdx][idx],idx,arrIdx};
		minHeap.add(currArr);
		return Math.max(max,arr[arrIdx][idx]);
	}
}


