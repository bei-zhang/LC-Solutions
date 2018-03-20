package algorithm.BinarySearch;

public class SearchInRotatedSortedArray {

	 /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A==null || A.length ==0){
            return -1;
        }
       
        int start=0, end = A.length -1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(A[mid] == target){
                return mid;
            }else if( A[mid] > A[A.length -1]  ){
                start = mid;
            }else{
                end = mid;
            }
        }
        
        
        if(A[start] == target ){
          return start;
        }
        if(A[end] == target ){
          return end;
        }
        
        System.out.println(A[start]);
        System.out.println(A[end]);
        
        if(target> A[0] && target < A[start] ){
          return binarySearch(A, 0,start, target);
        }
        if(target > A[end] && target < A[A.length-1] ){
          return binarySearch(A, end, A.length-1, target);
        }

        
        return -1;
        
    }
    
    private int binarySearch(int[] A, int start,int end, int target) {
        
        while (start + 1 < end){
            int mid = start + (end - start)/2;
             if(A[mid] == target){
                 return mid;
             }else if(A[mid] > target){
                 end = mid;
             }else if (A[mid] < target){
                 start = mid;
             }
        }
        
        if(A[start] == target){
            return start;
        }
         if(A[end] == target){
            return end;
        }
        
        return -1;
    }
    
    
	public static void main(String[] args) {
		int[] A = {0,1,2,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1};
		SearchInRotatedSortedArray instance = new SearchInRotatedSortedArray();
		System.out.println( "resutl is "  + instance.search(A, -9));

	}

}
