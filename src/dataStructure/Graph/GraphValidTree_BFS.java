package dataStructure.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import dataStructure.Graph.UnionFind.GraphValidTree;

/**
 * 
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.
 * 
 * http://www.lintcode.com/en/problem/graph-valid-tree/
 * http://www.jiuzhang.com/solutions/graph-valid-tree/
 * http://www.cnblogs.com/grandyang/p/5257919.html
 * 
 * 
 * 1). UnionFind :  O(n+m) time, even for worse case,   O(n) extra space           See {@GraphValidTree.java} for UnionFind solution
 * 2). BFS  :  O(n+m) time,   worse case O(n^2) time   O(n+m) extra space 
 * 3). DFS
 * 
 *
 */
public class GraphValidTree_BFS{

	/**
	 * Solution#1:  UnionFind：  see 
	 * See {@GraphValidTree.java} for UnionFind solution
	 */
	
	//Solution#2:  BFS: O(n+m) time,   worse case O(n^2)
    public boolean validTree(int n, int[][] edges) {
    	if(n==0){
    		return false;
    	}
    	//-- 只有当给定的边edges[][] 里面没有重复，才可以这样判断。此题目可加此判断也可以不加, 因为下面在遍历时，我们remove the edge from neighbor's vertex
    	/*if(edges.length != n-1){//小技巧：  A tree should have n nodes with n-1 edges
    		return false;
    	}
    	*/
    	
    	//initialize graph - save graph via HashMap data structure
    	HashMap<Integer, Set<Integer>> graph = initializeGraph(n, edges);
    	
    	//----START-------Standard BFS algorithm template for graph to get all nodes----------------
    	Queue<Integer> queue = new LinkedList<>();
    	//Save nodes in ArrayList while checking each edge.
    	List<Integer> list = new ArrayList<>();
    	
    	queue.offer(0);
    	list.add(0);
    	while(!queue.isEmpty()){
    		int head = queue.poll();
    		for(int neighbor : graph.get(head)){
    			if(list.contains(neighbor)){
    				return false;
    			}
    			queue.offer(neighbor);
    			list.add(neighbor);
    			//Must remove this edge from neighbor's node, otherwise this edge will be checked again.
    			graph.get(neighbor).remove(head); 

    		}
    	}
        //-----END------Standard BFS template for graph to get all nodes----------------

    	//return true if the number of nodes from edges equals to given nodes n.
    	return list.size() == n;
    	
    }
    
    private HashMap<Integer, Set<Integer>> initializeGraph(int n, int[][] edges){
    	HashMap<Integer, Set<Integer>> graph = new HashMap<>();
    	for(int i=0;i<n;i++){
    		graph.put(i, new HashSet<Integer>());
    	}
    	
    	for(int i=0; i<edges.length ;i++){
    		int u = edges[i][0];
    		int v = edges[i][1];
    		graph.get(u).add(v);
    		graph.get(v).add(u);
    		
    	}
    	
    	return graph;
    }
    
    
	public static void main(String[] args) {

		int n = 5;
		int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		//int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}};
		GraphValidTree_BFS instance = new GraphValidTree_BFS();
		System.out.println(instance.validTree(n,edges));
	}

}
