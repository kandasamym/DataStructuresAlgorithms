
public class LongestUniqueSubstringCount {
	public static void main(String[] args)
	{
		String s="aaaaabbbbbcd";
		int cnt = getMaxUniqueCount(s);
		System.out.println(cnt);
	}

	private static int getMaxUniqueCount(String s) {
		if(s==null || s.length()==0)
			return 0;
		boolean[] lookup = new boolean[256];
		int i=0;
		lookup[s.charAt(i)]=true;
		int j=1;
		int count=1;
		while(j<s.length()) {
			char c=s.charAt(j);
			if(lookup[c]==false) {
				lookup[c]=true;
				count=Math.max(count, j-i+1);
				j++;
			}
			else {
				lookup[s.charAt(i)]=false;
				i++;
			}
		}
		
		return count;
	}
}
