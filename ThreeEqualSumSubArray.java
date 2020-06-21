

import java.util.Stack;

public class ThreeEqualSumSubArray {

	public static void main(String[] args) {
		int[] arr=new int[] {-6,-7,9,6 ,0,2,1,2, 0,1,1,-100,50,52,-2};
//		Back tracking approach
		Stack<Integer> out=get3EqualSubArray(arr);
//		null is just a separator
		System.out.println(out);
	}

	private static Stack<Integer> get3EqualSubArray(int[] arr) {
		Stack<Integer> out=new Stack<Integer>();
		int sum=0;
		for(int i=0;i<arr.length;i++)
			sum+=arr[i];
		System.out.println("Three equal sum: "+sum/3);
		if(sum%3!=0)
			return null;
		
		boolean[] visited=new boolean[arr.length];
		if(get3EqualSubArray(arr,out,visited,0,sum/3,0,3))
			return out;
		return null;
	}

	private static boolean get3EqualSubArray(int[] arr, Stack<Integer> out,boolean[] visited,
			int start,int targetSum,int currSum,int count) {
		
		if(currSum==targetSum) {
			if(count==1) //last 1 remaining sub array
			{
				if(out.size()-2<arr.length)
				{
					for(int i=start;i<arr.length;i++)
					{
						if(!visited[i]) out.push(arr[i]);
					}
				}
				return true;
			}
			
			out.push(null); // for seprator purpose only
			return get3EqualSubArray(arr,out,visited,0,targetSum,0,count-1);
		}
		
		if(currSum>targetSum)
			return false;
		
		for(int i=start;i<arr.length;i++)
		{
			if(!visited[i]) {
				visited[i]=true;
				out.push(arr[i]);
				if(get3EqualSubArray(arr,out,visited,i+1,targetSum,currSum+arr[i],count))
					return true;
				while(out.pop()==null);
//				out.removeLast();
				visited[i]=false;
			}
		}
		return false;
	}

}
