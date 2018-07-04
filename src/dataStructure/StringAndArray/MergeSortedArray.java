package dataStructure.StringAndArray;


/**
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * 
 * Notice:
 * You may assume that A has enough space (size that is greater or equal to m + n) 
 * 			to hold additional elements from B. 
 * The number of elements initialized in A and B are m and n respectively.
 * 
 * https://leetcode.com/problems/merge-sorted-array/
 * http://www.lintcode.com/en/problem/merge-sorted-array/
 * 
 * 
* 个人总结： 
* This is similar to the merge step of Merge Sort. The differences are as follows:
1. We don't need extra space since the size of A is m+n.
2. Save value to array from right to left. 打破惯性思维，此题是从数组最后面往前面 来保存数值
3. No need to check i>=0 for array A in the last step since they are in array A.



 */
public class MergeSortedArray {
	//此题assume Array A 有额外空间可容纳 B, 否则请看下面 Solution2 merge到一个新的array里
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        if(B == null || B.length ==0){
            return;
        }
        //Save value to array from right to left. 打破惯性思维，此题是从数组最后面往前面 来保存数值
        int i=m-1, j=n-1, k=m+n-1;
        while(i>=0 && j >=0){
            if(A[i] < B[j]){
                A[k--] = B[j--];
            }else{
                 A[k--] = A[i--];
            }
     
        }
        
        while(j>=0){
            A[k--] = B[j--];
        }
    
       //No need to check i>=0 for array A in the last step since they are in array A. 
       /* while(i>=0){
            A[k--] = A[i--];
        }*/
       
        
    }

/////////////////下题是假设 A 和 B 都没有extra space，需要merge 到一个新的 array ///////////
    /**
     * 
     * Real Interview question by LinkedIn in Sep.2014​
    ​  Given two lists of numbers in descending order, 
      write a function that returns a single list sorted in the same order.

    E.g.

    list1: 4, 2, 1
    list2: 7, 6, 5, 3

    Result list should be: 7,6,5,4,3,2,1

    public List<Integer> merge(List<Integer> list1,List<Integer> list2){

    }
      面试总结：  need to clarify with interviewer if the given list is LinkedList or ArrayList
     
     MergeSortedArray.java
     
     */
    class Solution2{
        public int[] mergeSortedArray(int[] A, int[] B) {
            if (A == null || B == null) {
                return null;
            }
            
            int[] result = new int[A.length + B.length];
            int i = 0, j = 0, index = 0;
            
            while (i < A.length && j < B.length) {
                if (A[i] < B[j]) {
                    result[index++] = A[i++];
                } else {
                    result[index++] = B[j++];
                }
            }
            
            while (i < A.length) {
                result[index++] = A[i++];
            }
            while (j < B.length) {
                result[index++] = B[j++];
            }
            
            return result;
        }
    }

}
