package SystemDesign;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * http://www.lintcode.com/en/problem/tiny-url/#
 * http://www.jiuzhang.com/solution/tiny-url
 * 
 * two solutions: 
 *  1) Random fixed-length encoding
 *  	drawback is when there are huge URLs, generateRandomTinyUrl() may need to call many times. 
 *  2) base62: drawback is  it is very easy to predict the next code generated
 * 
 * 	10进制是decimal或base-10
	16进制是hex或base-16
    32进制 是   base-32
    
    62进制 是   base-62
 *
 */

//version 1: Random fixed-length encoding (Recommended)
//drawback is when there are more URLs, generateRandomTinyUrl() may need to call many times.
public class TinyUrl {
	private Map<String, String> long2Short;
	private Map<String, String> short2Long;
	public TinyUrl() {
	   long2Short = new HashMap<String, String>();
	   short2Long = new HashMap<String, String>();
	}
	//Encode: Long URL - > short URL
	public String encode(String longUrl) {
	   if (long2Short.containsKey(longUrl)) {
	       return long2Short.get(longUrl);
	   }
	   String shortURL = generateRandomTinyUrl();
	   while(short2Long.containsKey(shortURL)){
		   shortURL = generateRandomTinyUrl();
	   }
	   short2Long.put(shortURL, longUrl);
	   long2Short.put(longUrl, shortURL);
	   return shortURL;
	}
	//Decode: Short URL - > Long URL
	public String decode(String shortUrl) {
	   return short2Long.get(shortUrl);
	}
	private String generateRandomTinyUrl() {
	   String allowedChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	   Random random = new Random();
	   StringBuilder tinyUrl = new StringBuilder("http://tiny.url/");
	   for (int i = 0; i < 6; i++) {
	       tinyUrl.append(allowedChars.charAt(random.nextInt(62)));
	   }
	   return tinyUrl.toString();
	}
}

//////////////////////////////////////////////////////////////////////////
//version 2: base62
//One problem with this solution is that it is very easy to predict the next code generated
 class Solution2 {
    public static int GLOBAL_ID = 0;
    private HashMap<Integer, String> id2url = new HashMap<Integer, String>();
    private HashMap<String, Integer> url2id = new HashMap<String, Integer>();
    
    /**
     * @param url a long url
     * @return a short url starts with http://tiny.url/
     */
    public String longToShort(String url) {
    	if(url2id.containsKey(url)){
    		return "http://tiny.url/" + idToShortKey(url2id.get(url));
    	}
    	GLOBAL_ID++;
    	url2id.put(url,GLOBAL_ID);
    	id2url.put(GLOBAL_ID, url);
    	return "http://tiny.url/" + idToShortKey(GLOBAL_ID);
    }

    /**
     * @param url a short url starts with http://tiny.url/
     * @return a long url
     */
    public String shortToLong(String url) {
    	String shortURL = url.substring("http://tiny.url/".length());
    	return id2url.get(shortURLToID(shortURL));
    }

    //generate short URL by base62 ID 62进制
    private String idToShortKey(int id) {
        String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String short_url = "";
        while (id > 0) {
            short_url = chars.charAt(id % 62) + short_url;
            id = id / 62;
        }
        while (short_url.length() < 6) {
            short_url = "0" + short_url;
        }
        return short_url;
    }
    
    //convert short URL to base62 ID (62进制的ID)
    private int shortURLToID(String shortURL){
    	int id =0;
    	for(int i=0;i<shortURL.length();i++){
    		id = id * 62 + toBase62(shortURL.charAt(i));
    	}
    	return id;
    }

	
    
    /*
     * Base62, like Base10 (decimal), Base16 (hexadecimal), is a number system. 
     * Base62 uses 62 possible ASCII letters, 0 – 9, a – z and A – Z, 
     * therefore it is often used to represent large numbers in short length of string. 
     * Mainly it has two advantages: A shorter number representation in base62 yields a smaller risk of error entered by human and the number can be typed in faster. The second advantage is that it can be used in a more restricted application where the length for URL or name, identify is limited.
     * https://helloacm.com/base62/
     * 
     */
    private int toBase62(char c){
    	if(c >= '0' && c <='9'){
    		return c - '0';
    	}
    	if (c >= 'a' && c <= 'z') {
             return c - 'a' + 10;
        }
        return c - 'A' + 36;
    }
    
	public static void main(String[] args) {

	}

}






