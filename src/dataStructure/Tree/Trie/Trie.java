package dataStructure.Tree.Trie;


/**
 * http://www.lintcode.com/en/problem/implement-trie/
 * https://leetcode.com/problems/implement-trie-prefix-tree/#/description
 * http://www.programcreek.com/2014/05/leetcode-implement-trie-prefix-tree-java/
 * 
 * 
 *
 */
class TrieNode {
    TrieNode[] children;
    public boolean isEnd;
    // Initialize your data structure here.
    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
}

public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() ==0){
            return;
        }
        TrieNode p = root;
        for(int i=0; i< word.length() ; i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(p.children[index] == null){
                 TrieNode temp = new TrieNode();
                 p.children[index] =temp;
                 p = temp;
            }else{
                p = p.children[index];
            }
            
        }
        p.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = findLastNode(word);
        return p!=null? p.isEnd : false;
        
    }

    // Returns if there is any word in the trie that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = findLastNode(prefix);
        return p!=null;
    }
    
    //a util method to find the last node of given word or prefix
    private TrieNode findLastNode(String str){
        if(str == null){
            return null;
        }
        TrieNode p = root;
        for(int i=0; i< str.length() ; i++){
            char c = str.charAt(i);
            int index = c - 'a';
            if(p.children[index] != null){
               p = p.children[index];
            }else{
                return null;
            }
            
        }
        return p;
    }
    
}