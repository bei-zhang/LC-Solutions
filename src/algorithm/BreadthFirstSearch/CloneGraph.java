package algorithm.BreadthFirstSearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import common.UndirectedGraphNode;



/**
 * 
 * https://leetcode.com/problems/clone-graph/#/description
 * http://www.lintcode.com/en/problem/clone-graph/
 * http://www.jiuzhang.com/solutions/clone-graph/
 * 
 *
 */
public class CloneGraph {

    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return null;
        }
        //three steps - 劝分不劝和， 能够分开一步一步来的， 就不要合并写
        
        //1. node -> nodes    --  use BFS algorithm to traverse the graph and get all nodes.
        Set<UndirectedGraphNode>  allNodes = getAllNodes(node);
        
        //2. nodes -> new nodes  -- copy nodes, store the old->new mapping information in a HashMap
        Map<UndirectedGraphNode,UndirectedGraphNode> mapping = new HashMap<>();
        for(UndirectedGraphNode n : allNodes){
        	mapping.put(n, new UndirectedGraphNode(n.label));
        }
        
        //3. edges -> new edges  -- copy neighbors(edges)
        for(UndirectedGraphNode n : allNodes){
        	UndirectedGraphNode newNode = mapping.get(n);
        	for(UndirectedGraphNode neighbor : n.neighbors){
        		UndirectedGraphNode newNeighbor = mapping.get(neighbor);
        		newNode.neighbors.add(newNeighbor);
        	}
        }
        
        return mapping.get(node);
    }
	
    //Standard BFS algorithm template for graph to get all nodes
    private Set<UndirectedGraphNode> getAllNodes (UndirectedGraphNode node){
    	Queue<UndirectedGraphNode> queue = new LinkedList<>();
    	//HashSet to save all nodes in edges to avoid duplicates (a node may get added multiple times)
    	Set<UndirectedGraphNode> set = new HashSet<>();
    	queue.offer(node);
    	set.add(node);
    	while(!queue.isEmpty()){
    		UndirectedGraphNode head = queue.poll();
    		for(UndirectedGraphNode neighbor : head.neighbors){
        		if(!set.contains(neighbor)){
        			set.add(neighbor);
        			queue.offer(neighbor);
        		}
    		}

    	}

    	return set;
    }
    
    


}
