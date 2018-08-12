package dataStructure.Graph.UnionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * LeetCode#305
 * https://leetcode.com/problems/number-of-islands-ii
 * http://www.lintcode.com/en/problem/number-of-islands-ii
 * 
 * 1) Brute force: use BFS like first version of number-of-islands. 
 * 		Time: O(K*m*n)
 * 
 * 
 * 2) Below is the optimal solution which use UnionFind data structure.
 *     Time: O(m*n + K)
 *     K is the number of operations,  takes O(m*n) time to initialize UnionFind data structure
 *
 *
 */
public class NumberOfIslandsII {
    public List<Integer> numOfIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<>();
        if(n <=0 || m <=0 || operators==null || operators.length ==0){
            return result;
        }
        
        int[][] matrix = new int[n][m];
        int N = n*m;
        int[] deltaX = {-1,1,0,0};
        int[] deltaY = {0,0,-1,1};
        
        UnionFind unionFind = new UnionFind(N);
        int count = 0;
        for(Point island: operators){
            if(matrix[island.x][island.y] == 1){//return if it's already island.
                result.add(count);
                continue;
            }
            count++;
            matrix[island.x][island.y] = 1;
            int islandIndex = convertMatrixToArray(island.x, island.y, m);
            //if it's already island, set its parent to itself initially.
            unionFind.parent[islandIndex] = islandIndex; 
            
            for(int i=0; i< deltaX.length;i++){
                Point neighbor = new Point(island.x + deltaX[i], island.y + deltaY[i]);
                int neighborIndex = convertMatrixToArray(neighbor.x, neighbor.y, m);
                if(isValidPoint(neighbor,n,m)){
                	int p = unionFind.find(neighborIndex);
                	//connect two only if their root parent are different. in case two of neighbors are already in one island.
                    if(p>= 0 && unionFind.find(islandIndex) != p){
                        unionFind.union(islandIndex, neighborIndex);
                        count--;
                    }

                }
            }
            
           
            result.add(count);
        }
        
        return result;
    }
    
    //Convert a 2D matrix/array to 1D array
    private int convertMatrixToArray(int x, int y, int m){
        return x*m + y;
    }
    private boolean isValidPoint(Point point, int n, int m){
        if(point.x >=0 && point.x <n && point.y>=0 && point.y <m){
            return true;
        }
        return false;
    }
    
    

class UnionFind{
    int[] parent = null;
    public UnionFind (int n){
        parent = new int[n];
        for(int i=0; i<n;i++){
            parent[i] =-1; //跟普通的UnionFind 不同之处，此处initialize to -1 
        }
    }
    
    private int find(int x){
        if(parent[x] <0)  return parent[x];
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    public void union(int a, int b){
        int root_a = find(a);
        int root_b = find(b);
        if(root_a != root_b){
            parent[root_a] = root_b;   
        }
    }

}

}

class Point {
	int x;
	int y;

	Point(int a, int b) {
		x = a;
		y = b;
	}
}


