package dataStructure.StringAndArray;

/**
 * https://www.jiuzhang.com/solution/count-and-say/
 * https://leetcode.com/problems/count-and-say
 * 
 *
 */
public class CountAndSay {

	//答案来自九章算法
	public String countAndSay(int n) {
        String oldString = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            char [] oldChars = oldString.toCharArray();

            for (int i = 0; i < oldChars.length; i++) {
                int count = 1;
                while ((i+1) < oldChars.length && oldChars[i] == oldChars[i+1]) {
                    count++;
                    i++;
                }
                sb.append(String.valueOf(count) + String.valueOf(oldChars[i]));
            }
            oldString = sb.toString();
        }

        return oldString;
    }
	
}
