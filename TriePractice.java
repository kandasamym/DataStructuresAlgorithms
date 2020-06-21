

import java.util.HashMap;
import java.util.Map;

public class TriePractice {

	public static class TrieNode {
		HashMap<Character,TrieNode> map=new HashMap<Character,TrieNode>();
		boolean endNode = false;
		int prefixCount=0;
	}
	
	public static void main(String[] args) {
		String[] arr= {"abc","abcd","ab","asdf","bc","bd"};
		TrieNode root=new TrieNode();;
		for(int i=0;i<arr.length;i++) {
			insert(root,arr[i]);
		}
		
		System.out.println(getPrefixCount(root,"ab"));
	}

	public static void insert(TrieNode node, String s)
	{
		TrieNode current=node;
		for(int i=0;i<s.length();i++) {
			TrieNode children = current.map.get(s.charAt(i));
			if(children==null){
				children = new TrieNode();
				current.map.put(s.charAt(i),children);
			}
			children.prefixCount++;
			current = children;
		}
		current.endNode=true;
	}
	
	public static int getPrefixCount(TrieNode node, String s) {
		for(int i=0;i<s.length();i++)
		{
			TrieNode children = node.map.get(s.charAt(i));
			if(children==null)
				return 0;
			node=children;
		}
		
//		traverse(node,s);
		return node.prefixCount;
	}
	
	public static void traverse(TrieNode node,String str)
	{
		if(node.endNode)
			System.out.println(str);
		for(Map.Entry<Character,TrieNode> entry:node.map.entrySet()) {
			traverse(entry.getValue(),str+entry.getKey());
		}
	}
}
