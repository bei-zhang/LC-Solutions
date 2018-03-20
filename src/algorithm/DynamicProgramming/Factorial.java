package algorithm.DynamicProgramming;

public class Factorial {

	//Method 1 ( Use Recursion ) 
    //Time Complexity: O(n), Extra Space: O(n)
	public int factorial1(int n) {
		if (n == 1) return 1;
		return n * factorial(n - 1);
	}
    //Method 2 (Use Dynamic Programming)
    //Time Complexity: O(n),  Extra Space: O(n)
	public int factorial2(int n) {
		if (n == 1) return 1;
		
		int[] f = new int[n + 1];
		f[1] = 1;
		for (int i = 2; i <= n; i++) {
			f[i] = i * f[i - 1];
		}
		return f[n];
	}
    //Method 3 (Space Optimized Dynamic Programming) - Best solution 
    //滚动数组优化一维
    //Time Complexity: O(n), Extra Space: O(1)
	public int factorial(int n) {
		if (n == 1) return 1;
		
		int result = 1;
		for (int i = 2; i <= n; i++) {
			result = i * result;
		}
		return result;
	}

	public static void main(String[] args) {

	}

}
