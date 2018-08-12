package dataStructure.Graph.UnionFind;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import common.UndirectedGraphNode;


/**
 * 
 * http://www.lintcode.com/en/problem/connected-component-in-undirected-graph/
 * 
 * 1) UnionFind
 * 2) BFS
 * 
 */
public class ConnectedComponentInUndirectedGraph {
	//UnionFind solution
	public class Solution {
	    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
	        List<List<Integer>> result = new ArrayList<>();
	        if(nodes == null || nodes.size() ==0){
	            return result;
	        }
	        HashSet<Integer> hashSet = new HashSet<>();
	        //1.Get all nodes
	        for(UndirectedGraphNode node : nodes){
	            hashSet.add(node.label);
	        }
	        //2. initial UnionFind
	        UnionFind uf = new UnionFind(hashSet);
	        
	        //3. connect nodes via UnionFind
	        for(UndirectedGraphNode node : nodes){
	            for(UndirectedGraphNode neighbor : node.neighbors){
	                uf.union(neighbor.label, node.label);
	            }
	        }
	        
	        //4. connected components
	        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
	        for(Integer label: hashSet){
	            Integer root = uf.find(label);
	            if(!hashMap.containsKey(root)){
	                List<Integer> list = new ArrayList<>();
	                list.add(label);
	                hashMap.put(root, list);
	            }else{
	                hashMap.get(root).add(label);
	            }
	            
	        }
	        
	        //5. output result
	        for(List<Integer> list : hashMap.values()){
	            Collections.sort(list);
	            result.add(list);
	        }
	        
	        return result;
	        
	    }
	    
	    //面试中要自己写 UnionFind data structure
	    class UnionFind {
	    	//here we use HashMap because we don't know the range of values. values may not be consecutive from 0 - n. 
	        private HashMap<Integer, Integer> parentMap = new HashMap<>();
	        public UnionFind(HashSet<Integer> hashSet) {
	            for(Integer label : hashSet){
	                parentMap.put(label,label);
	            }
	        }
	        
	        public int find(int x){
	            if(parentMap.get(x) == x){
	                return x;
	            }
	            parentMap.put(x, find(parentMap.get(x)));
	            
	            return parentMap.get(x);
	        }
	        
	        
	        public void union(int a, int b){
	            int root_a = find(a);
	            int root_b = find(b);
	            if(root_a != root_b){
	                parentMap.put(root_a, root_b);
	            }
	            
	        }
	        
	        
	    }
	}
	
}
