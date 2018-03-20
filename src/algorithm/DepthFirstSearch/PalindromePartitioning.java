package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/palindrome-partitioning/
 * http://www.jiuzhang.com/solutions/palindrome-partitioning/
 * 
 *
 */
public class PalindromePartitioning {

    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        
        List<String> partition = new ArrayList<String>();
        dfs(s, 0, partition, results);
        
        return results;
    }
    
    //DFS algorithms template
	private void dfs(String s, int startIndex, List<String> partition, List<List<String>> result) {
		
		//一直走到尽头，找到一组答案, 将其加入到result 里面
		if (startIndex == s.length()) {
			result.add(new ArrayList<String>(partition));
			return;
		}

		for (int i = startIndex; i < s.length(); i++) {
			String subStr = s.substring(startIndex, i + 1);
			if (!(isPalindrome(subStr))) {
				continue;
			}
			partition.add(subStr);
			dfs(s, i + 1, partition, result);
			//返回上一层再向叶子节点搜索
			partition.remove(partition.size() - 1);
		}
	}

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    
	
	public static void main(String[] args) {
		PalindromePartitioning instance = new PalindromePartitioning();
		
		List<List<String>> result = instance.partition("abcdcd"); 
		
		for(List<String> partition : result){
			System.out.println(partition.toString());
		}
	
		
		
	}

}
