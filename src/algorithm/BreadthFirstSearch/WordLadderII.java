package algorithm.BreadthFirstSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * LC# 126. Word Ladder II Given two words (beginWord and endWord), and a
 * dictionary's word list, find all shortest transformation sequence(s) from
 * beginWord to endWord, such that: 1. Only one letter can be changed at a time
 * 2. Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * 类似题：WordLadder.java WordLadderII就是在WordLadder基础上再使用 DFS output paths
 * WordLadder : BFS WordLadderII : BFS + DFS
 */
public class WordLadderII {
	class Solution {
		public List<List<String>> findLadders(String start, String end, List<String> wordList) {
			HashSet<String> wordSet = new HashSet<>(wordList);
			
			HashMap<String, List<String>> nodeNeighbors = new HashMap<>();// Neighbors for every node
			HashMap<String, Integer> distance = new HashMap<>();// Distance of every node from the start node

			wordSet.add(start);
			bfs(start, end, dict, nodeNeighbors, distance);
			
			List<List<String>> res = new ArrayList<>();
			dfs(start, end, nodeNeighbors, distance, new ArrayList<>(), res);
			return res;
		}
		
		private int ladderLength(String beginWord, String endWord, List<String> wordList) {
	        if(wordList == null || wordList.size() ==0) return 0;
	        //为了能在LeetCode 上AC, 必须得把List<String> 转成 Set<String>, 
	        //因为 contains() method takes O(n) time on ArrayList but only O(1) time on HashSet
	        Set<String> dict = new HashSet<>(wordList);
	        Queue<String> queue = new LinkedList<>();
	        Set<String> visisted =  new HashSet<>();
	        queue.offer(beginWord);
	        visisted.add(beginWord);
	        int level = 1;
	        while(!queue.isEmpty()){
	            int size = queue.size(); //需要按层记录
	            while(size-- >0){
	                String curWord = queue.poll();
	                List<String> neighbors = getNeighbors(curWord, dict);
	                for(String nextWord : neighbors){
	                    if(visisted.contains(nextWord))  continue;
	                    if(nextWord.equals(endWord)){
	                        return level +1;
	                    }
	                    queue.offer(nextWord);
	                    visisted.add(nextWord);
	                }
	            }
	            level++; //注意每一层结束要加1
	        }
	        return 0;
	    }
		
		// DFS: output all paths with the shortest distance.
		private void dfs(String cur, String end, HashMap<String, List<String>> nodeNeighbors,
				HashMap<String, Integer> distance, List<String> solution, List<List<String>> res) {
			solution.add(cur);
			if (end.equals(cur)) {
				res.add(new ArrayList<String>(solution));
			} else {
				for (String next : nodeNeighbors.get(cur)) {
					if (distance.get(next) == distance.get(cur) + 1) {
						dfs(next, end, nodeNeighbors, distance, solution, res);
					}
				}
			}
			solution.remove(solution.size() - 1);
		}
		
	}
	
	
	
	public List<List<String>> findLadders(String start, String end, List<String> wordList) {
		HashSet<String> dict = new HashSet<String>(wordList);
		List<List<String>> res = new ArrayList<List<String>>();
		HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for
																									// every node
		HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
		ArrayList<String> solution = new ArrayList<String>();

		dict.add(start);
		bfs(start, end, dict, nodeNeighbors, distance);
		dfs(start, end, dict, nodeNeighbors, distance, solution, res);
		return res;
	}

	// BFS: Trace every node's distance from the start node (level by level).
	private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors,
			HashMap<String, Integer> distance) {
		for (String str : dict)
			nodeNeighbors.put(str, new ArrayList<String>());

		Queue<String> queue = new LinkedList<String>();
		queue.offer(start);
		distance.put(start, 0);

		while (!queue.isEmpty()) {
			int count = queue.size();
			boolean foundEnd = false;
			for (int i = 0; i < count; i++) {
				String cur = queue.poll();
				int curDistance = distance.get(cur);
				ArrayList<String> neighbors = getNeighbors(cur, dict);

				for (String neighbor : neighbors) {
					nodeNeighbors.get(cur).add(neighbor);
					if (!distance.containsKey(neighbor)) {// Check if visited
						distance.put(neighbor, curDistance + 1);
						if (end.equals(neighbor))// Found the shortest path
							foundEnd = true;
						else
							queue.offer(neighbor);
					}
				}
			}

			if (foundEnd)
				break;
		}
	}

	// Find all next level nodes.
	private ArrayList<String> getNeighbors(String node, Set<String> dict) {
		ArrayList<String> res = new ArrayList<String>();
		char chs[] = node.toCharArray();

		for (char ch = 'a'; ch <= 'z'; ch++) {
			for (int i = 0; i < chs.length; i++) {
				if (chs[i] == ch)
					continue;
				char old_ch = chs[i];
				chs[i] = ch;
				if (dict.contains(String.valueOf(chs))) {
					res.add(String.valueOf(chs));
				}
				chs[i] = old_ch;
			}

		}
		return res;
	}


}
