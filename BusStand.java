
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class BusStand {

	public static void main(String[] args) {
		int k=2;
		List<Integer> p = Arrays.asList(new Integer[] {1,4,4,3,1,2,6});
		List<Integer> q = Arrays.asList(new Integer[] {1,2,3,4,5,6,7});
		List<Integer> kthPerson=kthPerson(k, p, q);
		System.out.println(Arrays.toString(kthPerson.toArray()));
	}
	
	public static List<Integer> kthPerson(int k, List<Integer> p, List<Integer> q){
		List<Integer> out=new ArrayList<Integer>();
		List<Integer> ansPreProcessed = createAns(k,p);
		int ansLen=ansPreProcessed.size();
		for(Integer query : q) {
			if(query<=ansLen) out.add(ansPreProcessed.get(query-1));
			else out.add(0);
		}
		return out;
	}
	
	public static List<Integer> createAns(int k, List<Integer> p) {
		List<Integer> ansPreProcessed=new ArrayList<Integer>();
		PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
		int len=p.size();
		int i=0;
		int arrivalTime=1;
		while(i<len) {
			while(!minHeap.isEmpty() && minHeap.peek()<arrivalTime) minHeap.poll();
			while(minHeap.size()<k && i<len) {
				int pValue=p.get(i++);
				if(pValue>=arrivalTime) {
					minHeap.add(pValue);
				}
			}
			if(minHeap.size()==k) {
				ansPreProcessed.add(i);
			}
			arrivalTime++;
		}
		return ansPreProcessed;
	}
}
