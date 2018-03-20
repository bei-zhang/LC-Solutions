package dataStructure.Tree.Trie;

public class AddAndSearchWord {

    class WordDictionary {
	    private TrieNode root;
	    
	    public WordDictionary(){
	        this.root = new TrieNode();
	    }

	    // Adds a word into the data structure.
	    public void addWord(String word) {
	        if(word == null){
	            return;
	        }
	        TrieNode p = root;
	        for(int i=0; i<word.length();i++){
	            char c = word.charAt(i);
	            int index = c - 'a';
	            if(p.children[index] == null){
	                TrieNode temp = new TrieNode();
	                p.children[index] = temp;
	                p = temp;
	            }else{
	                p =  p.children[index];
	            }
	        }
	        
	        p.isEnd = true;
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public boolean search(String word) {
	       return searchWordHelper(word, 0, root);
	    }
	    
	    private boolean searchWordHelper(String word, int position, TrieNode current){
	        //到最后一个节点时，position是指向下一个空节点的，所以是position == word.length() 而不是position == word.length()-1
	        if(position == word.length()){
	            return current.isEnd;
	        }
	        
	        char c = word.charAt(position);
	        if(c == '.'){
	            //如果是. 那么查看26个分支中的每一个，然后接着递归查找
	            for(int i =0; i<26;i++){
	                if(current.children[i] !=null){
	                    //递归到最后返回true, 那么证明至少有一条路径可以找到匹配的word
	                    if(searchWordHelper(word, position+1, current.children[i])){
	                        return true; 
	                    }
	                }
	            
	            }
	            //如果执行到此，证明查看了26个分支后，仍然没有找到匹配的word，所以要返回false
	            return false;
	        }else if(current.children[c - 'a'] !=null ){
	            return searchWordHelper(word, position+1, current.children[c - 'a']);
	        }else{
	            return false;
	        }
	        

	    }
	    
	    
	}

	class TrieNode {
	    TrieNode[] children = null;
	    boolean isEnd;
	    public TrieNode(){
	        this.children = new TrieNode[26];
	        this.isEnd = false;
	    }
	}


	
	public static void main(String[] args) {
		// Your WordDictionary object will be instantiated and called as such:
		// WordDictionary wordDictionary = new WordDictionary();
		// wordDictionary.addWord("word");
		// wordDictionary.search("pattern");
		

	}

}
