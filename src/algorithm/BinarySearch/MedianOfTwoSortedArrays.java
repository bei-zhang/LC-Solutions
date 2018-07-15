package algorithm.BinarySearch;
/**
 * LC# 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * https://blog.csdn.net/chen_xinjia/article/details/69258706
 * https://www.jiuzhang.com/solution/median-of-two-sorted-arrays/
 * 
 *
 */
public class MedianOfTwoSortedArrays {
	//Time: O(log(min(m,n)))
	class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	        if(nums1.length > nums2.length) {
	        	findMedianSortedArrays(nums2, nums1);
	        }
	        int len = nums1.length + nums2.length;
	        int cut1 = 0;//分别表示的是数组1，数组2左边的元素的个数。 
	        int cut2 = 0;//分别表示的是数组1，数组2左边的元素的个数。 
	        int cutL = 0;
	        int cutR = nums1.length;
	        while(cut1 <= nums1.length) {
	        	cut1 = (cutR - cutL)/2 + cutL;
	        	cut2 = len / 2 - cut1;
	        	double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
	        	double L2 = (cut2 ==0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
	        	double R1 = (cut1 ==0) ? Integer.MAX_VALUE : nums1[cut1];
	        	double R2 = (cut2 ==0) ? Integer.MAX_VALUE : nums2[cut2];
	        	if(L1 > R2) {
	        		cutR = cut1 - 1;
	        	}else if(L2 > R1) {
	        		cutL = cut1 + 1;
	        	}else {
	        		if(len % 2 ==0) {
	        			L1 = L1 > L2 ? L1 : L2;
	        			R1 = R1 < R2 ? R1 : R2;
	        			return (L1 + R1) / 2;
	        		}else {
	        			return (R1 < R2) ? R1 : R2;
	        		}
	        	}
	        }
	        
	        return -1;
	        
	    }
	}
	
	//来自九章,  Time: O(log(m + n))
	class Solution2 {
		public double findMedianSortedArrays(int nums1[], int nums2[]) {
	        int n = nums1.length + nums2.length;
	        
	        if (n % 2 == 0) {
	            return (
	                findKth(nums1, 0, nums2, 0, n / 2) + 
	                findKth(nums1, 0, nums2, 0, n / 2 + 1)
	            ) / 2.0;
	        }
	        
	        return findKth(nums1, 0, nums2, 0, n / 2 + 1);
	    }

	    // find kth number of two sorted array
	    public  int findKth(int[] A, int startOfA,
	                              int[] B, int startOfB,
	                              int k){       
	        if (startOfA >= A.length) {
	            return B[startOfB + k - 1];
	        }
	        if (startOfB >= B.length) {
	            return A[startOfA + k - 1];
	        }

	        if (k == 1) {
	            return Math.min(A[startOfA], B[startOfB]);
	        }
	        
	        int halfKthOfA = startOfA + k / 2 - 1 < A.length
	            ? A[startOfA + k / 2 - 1]
	            : Integer.MAX_VALUE;
	        int halfKthOfB = startOfB + k / 2 - 1 < B.length
	            ? B[startOfB + k / 2 - 1]
	            : Integer.MAX_VALUE; 
	        
	        if (halfKthOfA < halfKthOfB) {
	            return findKth(A, startOfA + k / 2, B, startOfB, k - k / 2);
	        } else {
	            return findKth(A, startOfA, B, startOfB + k / 2, k - k / 2);
	        }
	    }
	}
	
}
