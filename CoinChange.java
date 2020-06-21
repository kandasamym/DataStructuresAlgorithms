import java.util.LinkedList;

public class CoinChange {

	public static void main(String[] args) {
		int n=4;
		int[] coins=new int[] {1,2,3};
		LinkedList<Integer> list=new LinkedList<Integer>();
		recur(coins,0,n,0,list);

	}

	private static void recur(int[] coins, int idx, int n, int sum, LinkedList<Integer> list) {
		if(sum==n) {
			System.out.println(list);
			return;
		}
		if(sum>n || idx==coins.length) return;

		recur(coins,idx+1,n,sum,list);
		int count=0;
		while(sum<n) {
			count++;
			sum+=coins[idx];
			list.add(coins[idx]);
			recur(coins,idx+1,n,sum,list);
		}
		while(count>0) {
			list.removeLast();
			count--;
		}
	}
}
