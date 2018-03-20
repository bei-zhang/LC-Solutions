package algorithm.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 

http://www.lintcode.com/en/problem/topological-sorting/
http://www.jiuzhang.com/solutions/topological-sorting/

Given an directed graph, a topological order of the graph nodes is defined as follow:
• For each directed edge A -> B in graph, A must before B in the order list.
• The first node in the order can be any node in the graph with no nodes direct to it.

Find any topological order for the given graph.
 *
 */
public class TopologicalSorting {
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
    	if(graph == null){
    		return null;
    	}
    	ArrayList<DirectedGraphNode> result = new ArrayList<>();
    	
    	//1. count indegree -- save into a HashMap with node -> indegree
    	Map<DirectedGraphNode,Integer> indegree = getIndegree(graph);
    	
    	//2. Topological sorting - BSF
    	Queue<DirectedGraphNode> queue = new LinkedList<>();
    	
    	//start nodes
    	for(DirectedGraphNode node : graph){
    		if(indegree.get(node) == 0){
    			result.add(node);
    			queue.offer(node);
    		}
    	}
    	while(!queue.isEmpty()){
    		DirectedGraphNode head = queue.poll();
    		for(DirectedGraphNode neighbor : head.neighbors){
    			indegree.put(neighbor, indegree.get(neighbor) -1);
    			//indegree 起到了Hash Table (HashSet) 的作用,所以不需要另外用Hash table
    			if(indegree.get(neighbor) == 0){
        			result.add(neighbor);
        			queue.offer(neighbor);
        		}
    		}
    		
    	}
    	return result;
    }
    
    
	private Map<DirectedGraphNode,Integer> getIndegree(ArrayList<DirectedGraphNode> graph){
		Map<DirectedGraphNode,Integer> indegree = new HashMap<>();
		
		//initial
		for(DirectedGraphNode node : graph){
			indegree.put(node, 0);
		}
		
		for(DirectedGraphNode node : graph){
			for(DirectedGraphNode neighbor : node.neighbors){
				indegree.put(neighbor, indegree.get(neighbor) + 1);
			}
		}
		
		return indegree;
	}
	
	// Definition for Directed graph.
	class DirectedGraphNode {
		int label;
		ArrayList<DirectedGraphNode> neighbors;

		DirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<DirectedGraphNode>();
		}
	};
	
}
