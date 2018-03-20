package algorithm.DynamicProgramming;

/**
 * Find the Nth number in Fibonacci sequence.
 * http://www.lintcode.com/en/problem/fibonacci/
 *http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 *
 *
 */
public class Fibonacci {

	
    //Method 1 ( Use Recursion ) 
    //Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential. Extra Space: O(n)
	//We can observe that this implementation does a lot of repeated work. 
	//So this is a bad implementation for nth Fibonacci number.
	public static int fibonacci1(int n){
		//base case
		if(n <= 1) return n;
		return fibonacci1(n-1) + fibonacci1(n-2);
	}
	
    //Method 2 ( Use Dynamic Programming )
    //Time Complexity: O(n),  Extra Space: O(n)
    public static int fibonacci(int n) {
    	if(n <= 1) return n;
    	
        int[] f = new int[n+1];
        f[0] =0;
        f[1] =1;
        for(int i=2; i<=n;i++){
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }
    
    //Method 3 (Space Optimized Dynamic Programming) -- Best solution 
    //滚动数组优化一维
    //Time Complexity: O(n), Extra Space: O(1)
    public static int fibonacci3(int n) {
    	if(n <= 1)return n;
    	
        int a =0;
        int b =1;
        int result = 1;
        for(int i=2; i<=n;i++){
        	result = b + a;
        	a = b;
            b = result;
        }
        return result;
    }

    
	public static void main(String[] args) {
		for(int i=0; i<15;i++){
			System.out.print(Fibonacci.fibonacci1(i) +", ");
			//System.out.print(Fibonacci.fibonacci3(i) +", ");
			//System.out.println(Fibonacci.fibonacci1(i));
		}
		
	}
    
}
