package dataStructure.StringAndArray;

import java.util.ArrayList;
import java.util.List;

/**
 * LC# 271. Encode and Decode Strings
 * Design an algorithm to encode a list of strings to a string. 
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 * https://leetcode.com/problems/encode-and-decode-strings
 * 
 * Note: The string may contain any possible characters out of 256 valid ASCII characters. 
 * Your algorithm should be generalized enough to work on any possible characters.
 * 
 * Company: Appito (2018)
 *
 * 类似题: StringCompression.java
 * 
 */
public class SerializeDeserializeStrings {

    // Serialize/Encode a list of strings to a single string.
    public String serialize(List<String> strs) {
    	StringBuilder sb = new StringBuilder();
    	for(String str : strs) {
    		sb.append(str.length()).append("#").append(str);
    	}
        return sb.toString();
    }

    // Deserialize a single string to a list of strings.
    public List<String> deserialize(String encodedString) {
    	List<String> res = new ArrayList<>();
    	int i = 0;
    	while(i < encodedString.length()) {
    		int pound = encodedString.indexOf("#", i);
    		int len = Integer.parseInt(encodedString.substring(i, pound));
    		res.add(encodedString.substring(pound + 1, pound + len + 1));
    		i = pound + len +1;
    	}
    	return res;
    }
    
	
}
