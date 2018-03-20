package dataStructure.StringAndArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words
 * as you can in each line. Pad extra spaces ' ' when necessary so that each
 * line has exactly L characters.
 * 
 * https://leetcode.com/problems/text-justification/
 * 
 * http://www.programcreek.com/2014/05/leetcode-text-justification-java/
 * http://bangbingsyb.blogspot.com/2014/11/leetcode-text-justification.html
 * 
 * 
 *
 */
public class TextJustification {

	public class Solution {
		public List<String> fullJustify(String[] words, int maxWidth) {
			List<String> result = new ArrayList<String>();

			if (words == null || words.length == 0) {
				return result;
			}

			int count = 0;
			int last = 0;
			ArrayList<String> list = new ArrayList<String>();
			for (int i = 0; i < words.length; i++) {
				count = count + words[i].length();

				if (count + i - last > maxWidth) {
					int wordsLen = count - words[i].length();
					int spaceLen = maxWidth - wordsLen;
					int eachLen = 1;
					int extraLen = 0;

					if (i - last - 1 > 0) {
						eachLen = spaceLen / (i - last - 1);
						extraLen = spaceLen % (i - last - 1);
					}

					StringBuilder sb = new StringBuilder();

					for (int k = last; k < i - 1; k++) {
						sb.append(words[k]);

						int ce = 0;
						while (ce < eachLen) {
							sb.append(" ");
							ce++;
						}

						if (extraLen > 0) {
							sb.append(" ");
							extraLen--;
						}
					}

					sb.append(words[i - 1]);// last words in the line
					// if only one word in this line, need to fill left with
					// space
					while (sb.length() < maxWidth) {
						sb.append(" ");
					}

					result.add(sb.toString());

					last = i;
					count = words[i].length();
				}
			}

			int lastLen = 0;
			StringBuilder sb = new StringBuilder();

			for (int i = last; i < words.length - 1; i++) {
				count = count + words[i].length();
				sb.append(words[i] + " ");
			}

			sb.append(words[words.length - 1]);
			int d = 0;
			while (sb.length() < maxWidth) {
				sb.append(" ");
			}
			result.add(sb.toString());

			return result;
		}
	}

//////////////////////////
	//自己的解法，还未通过所有cases
	public class Solution2{
	    public List<String> fullJustify(String[] words, int maxWidth) {
	        List<String> result = new ArrayList<>();
	        if(words == null || words.length ==0){
	            return result;
	        }
	        int n = words.length;
	        int start=0, end =0;        
	        for(int i=0; i<n;i++){
	            int remaining = maxWidth;
	            start = end = i;
	            while(end<n && remaining >= words[end].length()){               
	                remaining = remaining - words[end].length() - 1;                    
	                end++;                
	            }
	            
	            result.add(getLineString(words,start,end-1,maxWidth,remaining+1));
	            
	            i = end -1;
	        }
	        return result;
	    }
	    
	    private String getLineString(String[] words, int start, int end, int maxWidth, int remaining){
	        StringBuilder sb = new StringBuilder();
	        if(end == words.length -1){//last line
	            for(String word : words){
	                if(sb.length() >0)
	                    sb.append(" ");
	                sb.append(word);
	            }
	            return sb.toString();
	        }    
	        
	        //not last line
	        if(start == end){//one word in a line                          
	            return paddingSpaces(words[start], maxWidth - start -1);
	        }else{
	            int even = remaining/(end - start);
	            int extra = remaining%(end - start);
	            for(int i=start; i<=end;i++){
	                words[i] = paddingSpaces(words[i], even);
	                if(extra > i - start){
	                    words[i] = words[i] + " ";
	                }
	                if(sb.length() >0)
	                    sb.append(" ");
	                sb.append(words[i]);
	            }
	            
	        }          
	                
	      return sb.toString();
	       
	    }
	    
	    private String paddingSpaces(String word, int numOfSpaces){
	        if(numOfSpaces <1)
	            return word;
	        StringBuilder sb = new StringBuilder();
	        sb.append(word);
	        for(int i= 1; i<=numOfSpaces; i++){
	            sb.append(" ");
	        }  
	        return sb.toString();
	    }
	}
	
	public static void main(String[] args) {

	}

}
