package algorithm.BinarySearch;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/find-k-closest-elements/
 * 
 *
 */
public class FindKClosestElements {
	
    //Best solution:  Time complexity is O(logn + k).  Extra Space is O(1)
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> result = new ArrayList<>();
        	if(arr == null || arr.length ==0 || k < 1) {
        		return result;
        	}
        	//int index = Arrays.binarySearch(arr, x);
        	//int index = Collections.binarySearch(arr, x);
        	int index = binarySearch(arr, x);    	
        	int i = index, j = index + 1;
        	while(k-- > 0) {
        		if(j >= arr.length || (i >=0 && Math.abs(arr[i]- x) <= Math.abs(arr[j] - x))) {
        			i--;
        		}else {  		
        			j++;
        		}
        	}      
        	
        	//Note: does not include i and j 
        	for(int p= i+1; p<j;p++){
                result.add(arr[p]);
            }
        	return result;  
        }
        

        /**
         * find the first index of x if it exists in the array
         * or return the index of the number which is closest to x. 
         */
        private int binarySearch(int[] arr, int x){
            int start = 0;
            int end = arr.length -1;
            while(start + 1 < end) {
            	int mid = start + (end - start)/2;
            	if(arr[mid] < x) {
            		start = mid;
            	}else {
            		end = mid;
            	}
            }			
            return start;
        }
        
    }
    
	public static void main(String[] args) {
		

		
	}

}
