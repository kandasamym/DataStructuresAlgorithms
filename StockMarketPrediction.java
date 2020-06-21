import java.util.Stack;

public class StockMarketPrediction {

	public static void main(String[] args) {
//		Input arrays changeable
		int[] stockData = new int[] {5,6,8,4,9,10,8,3,6,4};
		int[] queries = new int[] {3,1,8};
		
		int[] outPreProcessed = new int[stockData.length];
		Stack<Integer> helperStack=new Stack<Integer>();
		
//		Find nearest minimum value's index of left side only
		for(int i=0;i<stockData.length;i++) {
			int minIdx = getMinIdx(helperStack, stockData,i);
			outPreProcessed[i]=minIdx;
			helperStack.push(i);
		}
		
		helperStack.clear();
//		Find nearest minimum value's index of right side and update if len is less than left
		for(int i=stockData.length-1;i>=0;i--) {
			int minIdx = getMinIdx(helperStack, stockData,i);
			int existingMinIdx = outPreProcessed[i];
			if(minIdx!=-1) {
				if(existingMinIdx==-1 || minIdx-1 < i-existingMinIdx) {
					outPreProcessed[i]=minIdx;
				}
			}
			helperStack.push(i);
		}
		
//		Answering queries will be constant time, since we have calculated already
		for(int i=0;i<queries.length;i++) {
			int val = outPreProcessed[queries[i]-1];
			if(val!=-1) val++;
			System.out.println(val);
		}

	}
	

	private static int getMinIdx(Stack<Integer> helperStack, int[] stockData, int i) {
		while(!helperStack.isEmpty()) {
			int top = helperStack.peek();
			if(stockData[top]<stockData[i]) {
				return top;
			}
			helperStack.pop();
		}
		return -1;
	}

}
