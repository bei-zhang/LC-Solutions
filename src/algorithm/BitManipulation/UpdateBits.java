package algorithm.BitManipulation;

/**
 * http://www.lintcode.com/en/problem/update-bits/
 * 
 *
 *本题是自己独立解决的 @date 7/3/2017 
 *解题思路：
 *将n 分成 三部分，
 * 1) right  - 把 0 到 i-1 位的 bit 一个一个找出， 组成数 right, 代码实现就是其中的 for loop
 * 2) middle - 就是从 i 到 j 位的 bit， 先将上一步处理后的 n 右移 (j-i+1) 位，然后再 左移 (j-i+1) 位， 这样中间部分都是 0's bit
 *    		   然后再与 m 按位或操作， 这样就把m 放到n 的中间部位.
 * 3) left - 现在再把 最右边的 right 数放回来， 先左移 i， 腾出 i 个空位  (0's bit)， 然后再 按位或操作. 
 *
 */
public class UpdateBits {

    public static int updateBits(int n, int m, int i, int j) {
        int right=0;
        for(int k=0;k<i; k++){
            int lastBit = n & 1;
            right |= (lastBit << k );
            n >>>=1;
        }
        //注意两点：
        //1. 必须要用  unsigned right shift >>> , 这样无论正负数， 左边不足都补0 
        //2. bit shit can only shift up to 31 bits at a time.  n >> 32 或者 n << 32 都还是 n 自身
        //   however, we can shift 31 bit first and then shift 1 more bit if we want to shift 32 bits.
        n >>>= (j-i);
        n >>>= 1;
        
        n <<= (j-i);
        n <<= 1;
        
        n |= m;
        n <<= i;
        n |= right;
        
        return n;
    }
    
	public static void main(String[] args) {
		UpdateBits.updateBits(-11,-789,0,31);
		System.out.println(1<<31); 
		System.out.println(1<<32);
		System.out.println(1<<33);
		System.out.println(1<<34);

	}

}
