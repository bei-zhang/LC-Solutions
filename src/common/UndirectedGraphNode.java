package common;

import java.util.ArrayList;


// Definition for undirected graph.
public class UndirectedGraphNode {
	//为了适应题目，访问方便, 全部是public 
	public int label;
	public ArrayList<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};
	 
