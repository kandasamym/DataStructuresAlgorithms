
public class LongestPalindromeSubstring {

	public static void main(String[] args) {
		String s="sdggsdgabcdcbaasdf";
		String longestPol = getLongestPol(s);
		System.out.println(longestPol);
	}

	private static String getLongestPol(String s) {
		String longestPal="";
		for(int i=0;i<s.length();i++) {
			// even length palindrome finder
			String pal1=getPalindrome(s,i-1,i);
			// odd length palindrome finder
			String pal2 =getPalindrome(s,i-1,i+1);
			
			if(pal1.length()>longestPal.length()) longestPal=pal1;
			if(pal2.length()>longestPal.length()) longestPal=pal2;
		}
		return longestPal;
	}

	private static String getPalindrome(String s, int i, int j) {
		while(i>=0 && j<s.length()) {
			if(s.charAt(i)!=s.charAt(j)) break;
			i--;
			j++;
		}
		return s.substring(i+1, j);
	}

}
