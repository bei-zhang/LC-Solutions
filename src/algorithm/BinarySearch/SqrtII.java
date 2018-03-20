package algorithm.BinarySearch;

/**
 * http://www.lintcode.com/en/problem/sqrtx-ii/
 *
 * LinkedIn 高频题
 */
public class SqrtII {
	
	//Solution 1:  Binary Search   面试给出此解就行了， 不要写牛顿法 (面试官考察的就是此解，有人只会牛顿法不会Binary Search解法 onsite被挂)
    public double sqrt(double x) {
        double start =0, end = x;
        double eps = 1e-12; //NOTE1: Ask interviewer to get the precision.
        if(x <=1.0){ //NOTE2:  x <= 1.0 特殊考虑
            end = 1.0;
        }
        while(end - start > eps){
        	 // 二分浮点数 和二分整数不同
            // 一般都有一个精度的要求 譬如这题就是要求小数点后八位
            // 也就是只要我们二分的结果达到了这个精度的要求就可以
            // 所以 需要让 start 和 end 小于一个我们事先设定好的精度值 eps
            // 一般eps的设定1e-8,因为这题的要求是到1e-8,所以我把精度增加2-4位， 调到了1e-12
            // 最后 选择 start 或 end 作为一个结果即可 
            double mid = start + (end - start)/2;
            if(mid * mid < x){
                start = mid;
            }else{
                end = mid;
            }
        }
        return start;
            
    }
    
	

	//Solution 2:  牛顿法  Newton's method for square root
	public class Solution2 {
		/**
		 * @param x  a double
		 * @return the square root of x
		 */
		public double sqrt(double x) {
			double result = 1.0;
			double eps = 1e-12;

			while (Math.abs(result * result - x) > eps) {
				result = (result + x / result) / 2;
			}

			return result;

		}
	}

	public static void main(String[] args) {
		//E-notation: Most calculators and many computer programs present very large and very small results in scientific notation, 
		//typically invoked by a key labelled EXP (for exponent)
		double eps = 1e-12; //表示精度到小数点后12位  1*10^-12  
		double eps3 = 2e+3; //
		double eps6 = 0.00000000000000000000000000000006666;
		System.out.println(eps);
		System.out.println(eps3);
		System.out.println(eps6);
		System.out.println(eps6/2);
		int a =1;
		long b = a+2;
		int c = (int)b;

	}

}
