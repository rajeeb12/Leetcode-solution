class Node{
    Node arr[];
    boolean isEndingWord;
    public Node(){
        arr = new Node[26];
        isEndingWord = false;
    }
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;

        for(char c: word.toCharArray()){
            if(curr.arr[c-'a'] == null) curr.arr[c-'a'] = new Node();
            curr = curr.arr[c-'a'];
        }
        curr.isEndingWord = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char c: word.toCharArray()){
            if(curr.arr[c-'a'] == null) return false;
            curr = curr.arr[c-'a'];
        }
        if(curr.isEndingWord) return true;
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char c: prefix.toCharArray()){
            if(curr.arr[c-'a'] == null) return false;
            curr = curr.arr[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */