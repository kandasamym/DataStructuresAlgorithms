import java.util.LinkedHashMap;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		map.put('a', 1);
		map.put('b', 1);
		map.put('a', 1);
		map.put('b', 2);
		map.put('a', 3);
		map.remove('a');
		map.put('a', 3);
		map.put('b', 4);
		System.out.println(map);

	}

}
