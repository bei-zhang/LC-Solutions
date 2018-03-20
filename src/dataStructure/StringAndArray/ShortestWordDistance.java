package dataStructure.StringAndArray;

/**
 * Given a list of words and two words word1 and word2, 
 * return the shortest distance between these two words in the list.
For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 * https://leetcode.com/problems/shortest-word-distance/
 *
 *
 *Follow-up: ShortestWordDistanceII, ShortestWordDistanceIII
 *
 */
public class ShortestWordDistance {
	//Time complexity: O(n),  Space complexity: O(1)
	public int shortestDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0) {
			return 0;
		}
		int pos1 = -1, pos2 = -1;
		int shortestDistance = Integer.MAX_VALUE;
		boolean indexUpdated = false; // Update shortestDistance only when necessary.
		for (int i = 0; i < words.length; i++) {
			indexUpdated = false;
			if (words[i].equals(word1)) {
				pos1 = i;
				indexUpdated = true;
			}
			if (words[i].equals(word2)) {
				pos2 = i;
				indexUpdated = true;
			}
			if (indexUpdated && pos1 >= 0 && pos2 >= 0) {
				shortestDistance = Math.min(shortestDistance, Math.abs(pos1 - pos2));
			}
		}

		return shortestDistance;
	}
}
