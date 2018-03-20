package algorithm.DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 *
 * Given a list of numbers, return all possible permutations.
 * Notice: You can assume that there is no duplicate numbers in the list.

 *http://www.jiuzhang.com/solutions/permutations/
 *http://www.lintcode.com/en/problem/permutations/#
 *
 *
 ***********************************************
 *个人总结：
 * 此题 与 subsets 和 combination 的共同区别 是 1. 递归的方法里不需要 startIndex 这个参数， 因为permutation 可以往回走， 不过要注意不能重复加一个数
 * 此题 与 subsets 的区别还有第二点 2. 递归出口是有条件的： permutation.size() == nums.length
 ***********************************************
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> permutation = new ArrayList<>();
        if(nums == null || nums.length ==0){
            permutations.add(permutation);
            return permutations;
        }
        //Find all permutations starting with []
        dfs(permutations, permutation, nums);
        return permutations;
    }
    // 递归三要素
    //1. 递归的定义： (接收什么样的参数， 返回什么样的值， 做了什么事) - 把 以 permutation 开头的所有所有排列，放到 permutations里
    private void dfs(List<List<Integer>> permutations,List<Integer> permutation,int[] nums){
    	//3.递归的出口
        if(permutation.size() == nums.length){
            permutations.add( new ArrayList<Integer>(permutation) );
            return;
        }
        //2. 递归的拆解
        //[] -> [1..] , [2..], [3..]
        //[1..] -> [1,2.] , [1,3.] 
        for(int i=0;i<nums.length;i++){
        	//avoid duplicates, 此处也可以优化，采用 类似 Permutations II， 用boolean[] visited 来记录是否访问过
            if(permutation.contains(nums[i])){ // 
                continue;
            }
            //e.g. [1] - > [1,2]
            permutation.add(nums[i]);
            //当你对recursion比较熟悉后，人脑在模拟这个过程时，不需要继续往下深入， 只需要知道根据你已经对递归的定义，
            //下面再递归时， 一定会找到以 [1,2] 开头的所有排列
            dfs(permutations, permutation, nums);
            //backtracking  [1,2] -> [1]  
            permutation.remove(permutation.size() - 1);
        }
        
    }
    
	
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.push(6);
		stack.push(9);
		list.addAll(stack);
		
		
		boolean[] visited = new boolean[2];
		System.out.println("result: " +visited[0] + visited[1]);
		

	}

}
