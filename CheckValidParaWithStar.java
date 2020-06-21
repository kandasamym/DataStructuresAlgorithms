import java.util.LinkedList;

public class CheckValidParaWithStar {

	public static void main(String[] args) {
		String input="((**))))";
		boolean isValid=checkValidPara(input);
		System.out.println(isValid);
	}
	
	static boolean checkValidPara(String input){
		LinkedList<Character> list = new LinkedList<Character>();
		for(int i=0;i<input.length();i++) {
			char ch=input.charAt(i);
			if(ch=='(' || ch=='*') list.add(ch);
			
			else if(removeOpenParaOrStar(list) == false) return false;
		}
		
		int starCount=0;
		while(!list.isEmpty()) {
			if(list.removeLast()=='(') {
				if(--starCount<0) return false;
			}
			else starCount++;
		}
		return true;
	}
	
	static boolean removeOpenParaOrStar(LinkedList<Character> list) {
		return list.removeLastOccurrence('(') || list.removeLastOccurrence('*');
	}
}
