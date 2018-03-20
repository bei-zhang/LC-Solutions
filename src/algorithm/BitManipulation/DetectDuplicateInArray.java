package algorithm.BitManipulation;



//detect duplicate in array

//0 < arr[i] <= length for all and 0 <= i < length

//brute-force
//sort and check
//hashtable
//bit manipulation  最优解

public class DetectDuplicateInArray {


	public static boolean hasDuplicate(int[] arr){
		int check = 0;
		int len = arr.length;
		for(int i=0; i<len; i++){
			check ^= arr[i] ^ i; 
		}
		return check!=0;
	}
	
	
	public static void main(String[] args) {
		int[] test = new int[]{1,8};
		System.out.println(hasDuplicate(test));
		char a= '1';
		char z= 'z';
		System.out.println((int)a + "---"+ (int)z);
		
		
		
	}

}
