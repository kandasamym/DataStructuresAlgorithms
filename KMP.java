public class KMP {

	public static void main(String[] args) {
		String str= "aabaacaadaabaaba";
		String pat = "aaba";
		int strLen=str.length();
		int patLen=pat.length();
		int[] lps=new int[patLen];
		computeLPSArr(pat,lps);
		int i=0;
		int j=0;
		while(i<strLen) {
			if(str.charAt(i)==pat.charAt(j)) {
				i++;
				j++;
				if(j==patLen) {
					System.out.println("pattern found at index: " +(i-j));
					j=lps[j-1];
				}
			}
			else {
				if(j!=0) j=lps[j-1];
				else i++;
			}
		}

	}

	private static void computeLPSArr(String pat, int[] lps) {
		int i=0;
		lps[0]=0;
		int j=1;
		while(j<pat.length()) {
			if(pat.charAt(i)==pat.charAt(j)) {
				lps[j]=i+1;
				i++;
				j++;
			}
			else {
				if(i!=0) i=lps[i-1];
				else j++;
			}
		}
		
	}

}
