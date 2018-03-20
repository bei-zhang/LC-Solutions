package algorithm.Math;

/**
 * Convert a non-negative integer to its english words representation. 
 * Given input is guaranteed to be less than 2^31 -1 
 * For example,	
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 *
 * https://leetcode.com/problems/integer-to-english-words/
 *
 * 自己参考LeetCode上的答案 写出的 最优解,  better solution than others
 * Note: Integer.MAX_VALUE is 2^31 -1.     2^31 is 2 GB,  1 Giga = 1 Billion 
 * https://www.aqua-calc.com/page/powers-of-two
 * 
 */
public class IntegerToEnglishWords {
	static String[] LESS_THAN_TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
			"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	static String[] TENS = {"", "Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty", "Ninety"}; // < 100
	//注意此处不能含有Hundred,因为Billion, Million, Thousand 之间都是 1000 times 差距.  One Billion ->  1,000,000,000
	static String[] RADIX_WORDS = {"Billion","Million","Thousand"};  
	static int[] RADIX = {1000000000,1000000,1000};
	
    public static String numberToWords(int num){
        if(num == 0) return "Zero";
        StringBuilder sb = new StringBuilder();
        //Step#1: 转换大于 1000的部分 
        int times = 0;
		for (int i = 0; i < RADIX.length; i++) {
			times = num / RADIX[i];
			if (times > 0) {
				sb.append(convertUnderThousand(times) + " " + RADIX_WORDS[i] + " ");
				num = num % RADIX[i];
			}
		}
		//Step#2: convert 0 - 999
		sb.append(convertUnderThousand(num));
        return  sb.toString().trim();
    }
    
    //Convert any number between 0 - 999
    private static String convertUnderThousand(int num){
    	String res = "";
        if(num == 0){
            return "";
        }else if(num < 20){
        	res = LESS_THAN_TWENTY[num];
        }else if(num < 100){
        	res =  TENS[num/10] + " "+ convertUnderThousand(num % 10);
        }else{
        	res =  LESS_THAN_TWENTY[num/100] + " Hundred " + convertUnderThousand(num % 100);
        }
        return res.trim();
    }
    
	public static void main(String[] args) {
		System.out.println(numberToWords(19));
		System.out.println(numberToWords(118));
		System.out.println(numberToWords(1019));
		System.out.println(numberToWords(12345));
		System.out.println(numberToWords(1234567));
		System.out.println(Integer.MAX_VALUE + numberToWords(Integer.MAX_VALUE));
		
	}

}
