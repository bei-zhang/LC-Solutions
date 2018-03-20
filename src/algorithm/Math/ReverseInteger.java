package algorithm.Math;

/**
 * https://leetcode.com/problems/reverse-integer/
 * 
 *
 */
public class ReverseInteger {

	//Recommended Solution (specific for Java as Java doesn't throw overflow exception in arithmetic operation.)
	/**
	 * In Java, 
	 * 1. If it overflows, it goes back to the minimum value and continues from there. e.g. 2147483647 + 1 = -2147483648
	 * 2. If it underflows, it goes back to the maximum value and continues from there. e.g. -2147483648 -1 = 2147483647
	 */
	class Solution1 {
		public int reverse(int x) {
			int result = 0;
			while (x != 0) { 
				int tail = x % 10;
				int newResult = result * 10 + tail;
				if ((newResult - tail) / 10 != result) {
					return 0;
				}
				result = newResult;
				x = x / 10;
			}

			return result;
		}

	}
	
	//Generic Solution (applicable for other languages as we check against MAX and MIN if it overflows )
	class Solution2 {
		public int reverse(int x) {
			long result = 0L;
			while (x != 0) {
				long newResult = result * 10 + x % 10;
				if (newResult > Integer.MAX_VALUE || newResult < Integer.MIN_VALUE)
					return 0;
				result = newResult;
				x = x / 10;
			}

			return (int) result;
		}

	}
	
	//Naive solution:
	// We can convert the integer to a string/char array, reverse the order, and convert the string/char array back to an integer. 
	// However, this will require extra space for the string and it doesn't seem to be the right way.
	class Solution3 {
	    public int reverseInteger(int n) {
	        if(n<10 && n > -10)  return n;
	        if(n == Integer.MIN_VALUE) return 0;
	        
	        long posN = n>0? n: -1 *n;
	        long res = reverse(String.valueOf(posN));
	        res = n>0? res: -1 *res;
	        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
	            return 0;
	        }
	        
	        return (int)res; 
	    }
	    
	    private long reverse(String num){
	        char[] numArray = num.toCharArray();
	        int i=0, j=num.length() -1;
	        while(i < j){
	            char temp = numArray[i];
	            numArray[i] = numArray[j];
	            numArray[j] = temp;
	            i++;
	            j--;
	        }
	        return Long.parseLong(String.valueOf(numArray));
	    }
	}
	
	
	public static void main(String[] args) {

		System.out.println("MAX_VALUE is " + Integer.MAX_VALUE);
		System.out.println("MIN_VALUE is " + Integer.MIN_VALUE);
		//1534236469
		//2,147,483,647
		//2147483647  - MAX
	   //-2147483648  MIN
		

		System.out.println("Int value is " + Integer.parseInt("1534236469"));
		System.out.println("Int value is " + Integer.parseInt("2134236469"));
		
		System.out.println("96463243 * 10 is " + 96463243 * 10);
		
		int t1 = 964632435 * 10;
		System.out.println("t1 is " +  t1);
		
		
		int temp = 2;
		long k = 2147483647;
		long tl1 =  k + temp;
		System.out.println("Long tl1 is " +  tl1);
		
		System.out.println("(2147483647 - 964632435 ): " +  (2147483647 - 964632435 ));
	
		System.out.println("Overflow: " +  (Integer.MAX_VALUE + 1));
		System.out.println("Underflow: " +  (Integer.MIN_VALUE - 1));
		
		/*int a = 1056389758;
		System.out.println(a + " / 10 is " + a/10);
		
		System.out.println("Integer.MAX_VALUE + 1  is " +(Integer.MAX_VALUE + 1 ));
		System.out.println("Integer.MAX_VALUE + 2  is " +(Integer.MAX_VALUE + 2 ));*/
		
		ReverseInteger r = new ReverseInteger();
		Solution2 s = r.new Solution2();
		
		//System.out.println(s.reverseInteger(-2147483647));
	}

}
