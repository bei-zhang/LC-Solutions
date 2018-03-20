package algorithm.DynamicProgramming;

/**
 * http://www.lintcode.com/en/problem/edit-distance-ii/
 * 
 *
 * Alias name:  One Edit Distance  (LeetCode question)
 * 
 * 此题并非动态规划， 如果用 EditDistance那题的动规来解，时间复杂度是 O(n^2) 太高
 * 
 * 此题就是普通数组题，挨个判断每个字符即可.    时间复杂度 O(n)
 * 
 */
public class EditDistanceII {

    /**
     * @return true if they are both one edit distance apart or false
     */
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null){
            return false;
        }
        int n = s.length();
        int m = t.length();
        if(Math.abs(n-m) >1){
            return false;
        }
      
        if(n > m){
            return isOneEditDistance(t,s);
        }
        for(int i =0; i<n;i++){
            if(s.charAt(i) != t.charAt(i)){
                if(n == m){//长度相同，那么剩下的substring 必定要相同才行
                    return s.substring(i+1).equals(t.substring(i+1));
                }else{ //n = m+1
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
        }
        
        return n!=m;
       
    }
    
	public static void main(String[] args) {

	}

}
