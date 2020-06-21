
import java.util.HashMap;
import java.util.Map;

public class RemoveStringCount {
	
	public static void main(String[] args) {
		String s = "BALLOONBALLOO";
		System.out.println(solution(s));

	}
	
	public static int solution(String S) {
		if(S==null) return 0;
		HashMap<Character,Integer> freqMap=new HashMap<Character,Integer>();
		HashMap<Character,Integer> removeCharMap=createRemoveCharMap("BALLOON");
		int len=S.length();
		for(int i=0;i<len;i++) {
			char ch=S.charAt(i);
			if(removeCharMap.containsKey(ch)) {
				Integer val = freqMap.get(ch);
				if(val==null) val=0;
				freqMap.put(ch, val+1);
			}
		}
		
		Integer min=Integer.MAX_VALUE;
		for(Map.Entry<Character, Integer> entry:removeCharMap.entrySet()) {
			Character ch=entry.getKey();
			Integer freq=freqMap.get(ch);
			if(freq==null) {
				return 0;
			}
			Integer val=entry.getValue();
			freq/=val;
			min=Math.min(freq, min);
		}
		return min;
    }
	
	static HashMap<Character,Integer> createRemoveCharMap(String s){
		HashMap<Character,Integer> removeCharMap=new HashMap<Character,Integer>();
		int len=s.length();
		for(int i=0;i<len;i++) {
			char ch=s.charAt(i);
			Integer val = removeCharMap.get(ch);
			if(val==null) val=0;
			removeCharMap.put(ch, val+1);
		}
		return removeCharMap;
	}
	

}
