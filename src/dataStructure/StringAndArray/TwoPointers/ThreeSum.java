package dataStructure.StringAndArray.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Notice

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)

The solution set must not contain duplicate triplets.
Example
For example, given array S = {-1 0 1 2 -1 -4}, A solution set is:

(-1, 0, 1)
(-1, -1, 2)

 * 
 * http://www.lintcode.com/en/problem/3sum/
 * https://leetcode.com/problems/3sum
 * http://www.jiuzhang.com/solutions/3sum/
 * 
 *
 */
public class ThreeSum {

    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if(numbers ==null || numbers.length <3){
            return results;
        }
        //1. Sort the array 
        Arrays.sort(numbers);
        
        for(int i=0; i<numbers.length-2;i++){
            int target = - numbers[i];
            //先找到a, 那么问题就变成twoSum -> 在剩余Array中找 两数之和为 -a (target)
            twoSum(numbers,i+1, numbers.length -1, target, results);
            while(i<numbers.length-2 && numbers[i] == numbers[i+1]){
                i++;
            }
        }
        
        return results;
    }
    
    //Two pointers to get TwoSum in the remaining array
    private void twoSum(int[] numbers, int start, int end, int target,
                    ArrayList<ArrayList<Integer>> results){
        while(start < end){
            if(numbers[start] + numbers[end] == target){
                ArrayList<Integer> triplet = new ArrayList<>();
                triplet.add(-target);
                triplet.add(numbers[start]);
                triplet.add(numbers[end]);
                results.add(triplet);
                while(start < end && numbers[start] == numbers[start+1]){
                    start++;
                }
                while(start < end && numbers[end] == numbers[end-1]){
                    end--;
                }
                start++;
                end--;
            }else if(numbers[start] + numbers[end] > target){
                end--;
            }else{
                start++;
            }
        }
    }
    
	public static void main(String[] args) {
		int a =10;
		a*=10;
char c ='3';


	}

}
