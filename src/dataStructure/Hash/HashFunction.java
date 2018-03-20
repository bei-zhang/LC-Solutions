package dataStructure.Hash;


/**
 * http://www.lintcode.com/en/problem/hash-function/
 * 
 *
 */
public class HashFunction {

    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        if(key == null || key.length ==0 || HASH_SIZE==0){
            return 0;
        }
        long sum =0; // define as long to avoid integer out of range during calculation.
        for(int i=0; i<key.length;i++){
            sum = sum *33 + (int)key[i];
            sum = sum % HASH_SIZE;
        }
        return (int)sum; //convert int to long
    }
    
    
    
	public static void main(String[] args) {

	}

}
