package algorithm.Math;


/**
 * 
 ********In June, 2017, I got this question during 2nd round of  on-site interview at Amazon.*****
 * LC#12 原题
 * https://leetcode.com/problems/integer-to-roman/#/description
 * http://www.lintcode.com/en/problem/integer-to-roman/#
 * http://www.jiuzhang.com/solutions/integer-to-roman/
 * 
 *  Given an integer, convert it to a Roman numeral.
	The number is guaranteed to be within the range from 1 to 3999.
	
	
	类似题目:  RomantoInteger.java
 */
public class IntegerToRoman {
    public String intToRoman(int n) {
        if(n<1 || n >3999){
            return "";
        }
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] dict ={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        int index =0, times =0;
        while(n>0){
            times = n/nums[index];
            n = n - times * nums[index];
            while(times-- > 0){
                sb.append(dict[index]);
            }
            index++;
        }
        return sb.toString();

    }
    
	public static void main(String[] args) {
		IntegerToRoman instance = new IntegerToRoman();
		for(int i=1;i<4000;i++){
			System.out.println(i + " --> " + instance.intToRoman(i));
		}

	}

}
