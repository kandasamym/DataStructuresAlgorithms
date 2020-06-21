

import java.util.Arrays;
import java.util.LinkedList;

public class RelativeSequence {

	public static void main(String[] args) {
		Integer[] inputArr1=new Integer[] {1,2,3};
		Integer[] inputArr2=new Integer[] {4,5,6};
		LinkedList<Integer> list1 = new LinkedList<Integer>(Arrays.asList(inputArr1));
		LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(inputArr2));
		LinkedList<Integer> out = new LinkedList<Integer>();
		generateSeq(list1,list2,out);
	}
	
	static void generateSeq(LinkedList<Integer> list1,LinkedList<Integer> list2,LinkedList<Integer> out)
	{
		if(list1.isEmpty() || list2.isEmpty())
		{
			LinkedList<Integer> outClone=new LinkedList<Integer>(out);
			if(!list1.isEmpty()) {
				outClone.addAll(list1);
			}
			else {
				outClone.addAll(list2);
			}
			System.out.println(outClone);
			return;
		}
		Integer list1First = list1.removeFirst();
		out.addLast(list1First);
		generateSeq(list1,list2,out);
		out.removeLast();
		list1.addFirst(list1First);
		
		Integer list2First = list2.removeFirst();
		out.addLast(list2First);
		generateSeq(list1,list2,out);
		out.removeLast();
		list2.addFirst(list2First);
		
	}
}
	