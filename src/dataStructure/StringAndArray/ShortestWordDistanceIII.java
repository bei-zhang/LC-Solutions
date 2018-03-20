package dataStructure.StringAndArray;

/**
 * This is a follow up of Shortest Word Distance. 
 * The only difference is now word1 could be the same as word2.

 * https://leetcode.com/problems/shortest-word-distance-iii/
 *
 * Similar questions: ShortestWordDistance, ShortestWordDistanceII
 *
 */
public class ShortestWordDistanceIII {
	//Time complexity: O(n),  Space complexity: O(1)
    public int shortestWordDistance(String[] words, String word1, String word2) {
		if (words == null || words.length == 0) {
			return 0;
		}
		//初始化 pos1 = -2 ，是为了确保  pos1 < pos2  也是适用于  initial case 
		int pos1 = -2, pos2 = -1;
		int shortestDistance = Integer.MAX_VALUE;
		boolean indexUpdated = false; // Update shortestDistance only when necessary.
        boolean sameWord = word1.equals(word2);        
		for (int i = 0; i < words.length; i++) {
			indexUpdated = false;
            if( ((sameWord && pos1 < pos2)  || !sameWord)  && words[i].equals(word1) ){
                pos1 = i;
				indexUpdated = true;
            }else if ( words[i].equals(word2) ) {
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
