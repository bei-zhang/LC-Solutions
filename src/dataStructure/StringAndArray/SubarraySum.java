package dataStructure.StringAndArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * http://www.lintcode.com/en/problem/subarray-sum/
 * http://www.jiuzhang.com/solutions/subarray-sum/
 * 
 *
 */
public class SubarraySum {
    public ArrayList<Integer> subarraySum(int[] nums) {
        if(nums == null || nums.length ==0){
            return null;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int sum=0;
        Map<Integer,Integer> prefixSumMap = new HashMap<>();
        // 这一步很关键, 前面0个数相加和为sum=0, index 为 -1  (用下面同样的表达式即 i+1 =0)
        prefixSumMap.put(sum, -1); 
        for(int i=0;i<nums.length;i++){
            sum+= nums[i];
            if(prefixSumMap.containsKey(sum)){
                result.add(prefixSumMap.get(sum)+1);
                result.add(i);
                return result;
            }
            prefixSumMap.put(sum,i); //前面i+1个数相加和为sum, index 为 i
        }
        
        return result;
    }
    
	public static void main(String[] args) {

	}

}
