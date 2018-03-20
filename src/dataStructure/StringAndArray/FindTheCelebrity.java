package dataStructure.StringAndArray;

/**
 * 
 * https://leetcode.com/problems/find-the-celebrity/
 * http://www.jiuzhang.com/solution/find-the-celebrity
 * http://www.cnblogs.com/grandyang/p/5310649.html
 * 
 *
 */
public class FindTheCelebrity {

	/**
	 * 下面这种方法是网上比较流行的一种方法，设定候选人res为0，原理是先遍历一遍，对于遍历到的人i，若候选人res认识i，则将候选人res设为i，
	 * 完成一遍遍历后，我们来检测候选人res是否真正是名人，我们如果判断不是名人，则返回-1，如果并没有冲突，返回res
	 */
	public int findCelebrity(int n) {
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (knows(ans, i)) {
                ans = i;
            }
        }

        for (int i = 0; i < n; i++) {
            if (ans != i && (knows(ans, i) || !knows(i, ans))) {
                return -1;
            }
        }
        return ans;
    }
	
	//#2 Optimized solution - Two pointers solution
	// 双指针，O(n)时间，O(1)空间
	/**
	 *The idea is to use two pointers, one from start and one from the end. Assume the start person is A, 
	 *and the end person is B. If A knows B, then A must not be the celebrity. Else, B must not be the celebrity. 
	 *We will find a celebrity candidate at the end of the loop. Go through each person again and check whether this is the celebrity. 
	 */
	public int findCelebrity2(int n) {
		int start =0, end = n-1;
		while(start < end){
			if(knows(start, end)){
				start++;
			}else{
				end--;
			}
		}
		//At this point, as the while loop finishes, start is a celebrity candidate.
		//下面这个loop跟solution#1一样: Go through each person again and check whether this is the celebrity. 
		for(int i=0; i<n;i++){
			if(i != start && (knows(start, i) || !knows(i, start)) ){
				return -1;
			}
		}
		
		return start;
		
	}
	

	
	/* The knows API is defined in the parent class Relation. */
    boolean knows(int a, int b){
    	return true;
    }; 
	
	
	public static void main(String[] args) {

	}

}
