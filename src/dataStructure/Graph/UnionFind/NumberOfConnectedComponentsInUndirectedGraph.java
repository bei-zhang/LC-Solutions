package dataStructure.Graph.UnionFind;

/**
 * 323. Number of Connected Components in an Undirected Graph
 * 
 *
 */
public class NumberOfConnectedComponentsInUndirectedGraph {
	//Union Find (best solution)
	class Solution{
		private int[] parent;
		private int num;
	    public int countComponents(int n, int[][] edges) {
	    	 num = n;
	    	 parent = new int[n];
	         for (int i = 0; i < n; i++)
	        	 parent[i] = i; //initialize
	         
	         for (int[] e : edges) {
	        	 union(e[0], e[1]);
	         }
	         return num;
	    }
	    
		//Find root parent of given element. Compression Find: O(1) time
		private int find(int x){
			if(parent[x] == x) return x;
			return parent[x] = find(parent[x]); 
		}
		
		//Connect two sets by changing the root parent of one given element. 
		//union operation: O(1) time
		private void union(int a, int b){
			int root_a = find(a);
			int root_b = find(b);
			if(root_a != root_b){
				parent[root_a] = root_b;
				num--; //注意此处要 decrement --
			}
		}
	}

    
    
}
