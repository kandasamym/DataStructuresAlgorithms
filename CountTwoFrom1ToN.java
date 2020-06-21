

public class CountTwoFrom1ToN{
    public static void main(String[] args){
        int n=102;
        System.out.println(countTwoBruteForce(n));
        System.out.println(countTwoEfficient(n));
    }
    
	private static int countTwoEfficient(int n) {
		int nCopy=n;
        int count=0;
        int powerOf10=1;
        while(n>=2) {
        	int digit=n%10;
        	int leftPart = n/10;
        	count+=leftPart*powerOf10;
        	if(digit>2) {
        		count+=powerOf10;
        	}
        	if(digit==2) {
        		int rightPart=nCopy%powerOf10;
        		count+=rightPart+1;
        	}
        	n/=10;
        	powerOf10*=10;
        }
        return count;
	}
    
	private static int countTwoBruteForce(int n) {
		int count=0;
		while(n>0) {
			int nCopy=n;
			while(nCopy>0) {
				int rem=nCopy%10;
				if(rem==2)
					count++;
				nCopy/=10;
			}
			n--;
		}
		return count;
	}
}	