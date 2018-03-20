package dataStructure.Graph.UnionFind;


/**
 * Standard Union Find data structure template 
 * 
 * Time complexity of UnionFind initialization is O(n)
 */
public class UnionFind {
	private int[] parent;
	public UnionFind(int n){
		//initialize your data structure here
		parent = new int[n];
		for(int i =0; i<n; i++){
			parent[i] = i;
		}
	}
	//Find root parent of given element
	private int find(int x){
		if(parent[x] == x){
			return x;
		}
		//return find(parent[x]);  // not optimal solution: O(n) time
		return parent[x] = find(parent[x]); // Compression Find: O(1) time
	}
	
	//Connect two sets by changing the root parent of one given element. 
	public void union(int a, int b){
		int root_a = find(a);
		int root_b = find(b);
		if(root_a != root_b){
			parent[root_a] = root_b; //只需改老大哥的值，跟小弟无关
		}
	}

	//判断在不在同一个集合, are two in the same set? 
	public boolean query(int a, int b){
		int root_a = find(a);
		int root_b = find(b);
		return root_a == root_b;
	}
	
	
	
	public static void main(String[] args) {

	}

}
