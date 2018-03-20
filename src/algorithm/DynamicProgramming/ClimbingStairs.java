package algorithm.DynamicProgramming;


/**
 * http://www.lintcode.com/en/problem/climbing-stairs/
 * http://www.jiuzhang.com/solutions/climbing-stairs/
 * 
 * 
 *
 */
public class ClimbingStairs {

    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        //Fibonacci sequence 
        if (n <= 1) {
            return 1;
        }
        int last = 1, lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }
    
}
