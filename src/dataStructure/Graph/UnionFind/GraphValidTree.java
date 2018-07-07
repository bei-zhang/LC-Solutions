package dataStructure.Graph.UnionFind;




/**
 * 经典题目
 * See BFS solution on {@GraphValidTree_BFS.java}
 *
 */
public class GraphValidTree {

	//UnionFind:  O(n+m) time, even for worse case,   O(n) extra space
	public class Solution {
	    public boolean validTree(int n, int[][] edges) {
	        if(n <=0 || edges==null){
	            return false;
	        }
	        
	    	//-- 只有当给定的边edges[][] 里面没有重复，才可以这样判断。此题目可加此判断也可以不加, 因为下面在遍历时，我们remove the edge from neighbor's vertex
	    	/*if(edges.length != n-1){//小技巧：  A tree should have n nodes with n-1 edges
	    		return false;
	    	}
	    	*/
	        
	        UnionFind uf = new UnionFind(n);
	        for(int i =0; i<edges.length; i++){
	             if(uf.connect(edges[i][0], edges[i][1])){
	                 return false;
	             }
	        }
	        //如果所有点都connected，那么集合数应该是1
	        return uf.getCount() == 1;
	        
	    }
	    
	    
	    
	    class UnionFind {
	        private int[] parent = null;
	        private int count;
	        public UnionFind(int n){
	            parent = new int[n];
	            for(int i =0; i<n;i++){
	                parent[i] = i;
	            }
	            this.count = n; //初始化集合数
	        }
	        
	        public int find(int x){
	            if(parent[x] == x){
	                return x;
	            }
	            return parent[x] = find(parent[x]);
	        }
	        
	        public boolean connect(int a, int b){
	            int root_a = find(a);
	            int root_b = find(b);
	            if(root_a != root_b){
	                parent[root_a] = root_b;
	                count--; // 合并两点后，集合数减一
	                return false;
	            }
	            return true;
	        }
	        
	        public int getCount(){
	            return count;
	        }
	        
	        
	    }
	}
	
	public static void main(String[] args) {

	}

}
