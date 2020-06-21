

import java.util.Arrays;

public class SumSegmentTree {

	public static void main(String[] args) {
		int[] arr=new int[] {1,3,2};
		int len=arr.length;
		int segmentArrLen = getNextPowOf2(len);
		int[] segmentArr= new int[segmentArrLen];
		constructSumSegmentTree(arr,segmentArr,0,len-1,0);
		System.out.println(Arrays.toString(segmentArr));
		int sum = getSegmentSum(segmentArr,0,len-1,0,1,2);
		System.out.println(sum);
//		int givenIndex=0;
//		int givenVal=10;
//		update(arr,segmentArr,0,len-1,0,givenIndex,givenVal);
//		System.out.println(Arrays.toString(segmentArr));
	}
	
	private static int update(int[] arr, int[] segmentArr, int leftIdx, int rightIdx, int segmentTreeIdx,int givenIndex,int givenVal) {
		
		if(leftIdx==rightIdx && leftIdx==givenIndex) {
			arr[leftIdx] = givenVal;
			segmentArr[segmentTreeIdx]=arr[leftIdx];
			return segmentArr[segmentTreeIdx];
		}
		int mid = (leftIdx+rightIdx)/2;
		if(givenIndex>=leftIdx && givenIndex<=mid)
			update(arr,segmentArr,leftIdx,mid,2*segmentTreeIdx+1,givenIndex,givenVal);
		else
			update(arr,segmentArr,mid+1,rightIdx,2*segmentTreeIdx+2,givenIndex,givenVal);
		segmentArr[segmentTreeIdx]=segmentArr[2*segmentTreeIdx+1]+segmentArr[2*segmentTreeIdx+2];
		return segmentArr[segmentTreeIdx];
		
	}

	public static int constructSumSegmentTree(int[] arr,int[] segmentArr,int leftIdx,int rightIdx, int segmentTreeIdx)
	{
		if(leftIdx==rightIdx) {
			segmentArr[segmentTreeIdx]=arr[leftIdx];
			return segmentArr[segmentTreeIdx];
		}
		
		int mid = (leftIdx+rightIdx)/2;
		int leftSum=constructSumSegmentTree(arr,segmentArr,leftIdx,mid,2*segmentTreeIdx+1);
		int rightSum=constructSumSegmentTree(arr,segmentArr,mid+1,rightIdx,2*segmentTreeIdx+2);
		segmentArr[segmentTreeIdx]=leftSum+rightSum;
		return segmentArr[segmentTreeIdx];
	}
	
	public static int getSegmentSum(int[] segmentArr,int leftIdx,int rightIdx, int segmentTreeIdx,int givenLeftIdx,int givenrightIdx)
	{
		// if current range not within given range return 0
		if(rightIdx<givenLeftIdx || leftIdx>givenrightIdx) 
			return 0;
		
		// if current range within given range return segment idx value
		if(leftIdx>=givenLeftIdx && rightIdx<=givenrightIdx)
			return segmentArr[segmentTreeIdx];
		
		// if current range partially within given range go left and right sub tree
		int mid=(leftIdx+rightIdx)/2;
		return getSegmentSum(segmentArr,leftIdx,mid,2*segmentTreeIdx+1,givenLeftIdx,givenrightIdx)+
				getSegmentSum(segmentArr,mid+1,rightIdx,2*segmentTreeIdx+2,givenLeftIdx,givenrightIdx);
	}
	
	public static int getNextPowOf2(int n) {
		if((n&(n-1))==0) return 2*n;
		int powerOf2=1;
		while(n>0) {
			powerOf2<<=2;
			n>>=2;
		}
		return 2*powerOf2;
	}
}
