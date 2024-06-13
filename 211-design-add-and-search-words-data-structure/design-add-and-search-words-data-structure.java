class Node{
    Node arr[];
    boolean flag;
    public Node(){
        arr = new Node[26];
        flag = false;
    }

    public boolean containsKey(char c){
        return arr[c-'a'] != null;
    }

    public void put(char c, Node node){
        arr[c-'a'] = node;
    }
    public Node get(char c){
        return arr[c-'a'];
    }
    public boolean isEnd(){
        return flag;
    }
    public void setEnd(){
        flag = true;
    }
}
class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        for(char c: word.toCharArray()){
            if(!node.containsKey(c)){
                node.put(c, new Node());
            }
            node = node.get(c); 
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        return totalSearch(root, word, 0);
    }
    public boolean totalSearch(Node node, String word,int index){

        for(int i = index; i < word.length(); i++){
            if(word.charAt(i) == '.')
            {
                for(int j = 0; j < 26; j++)
                {
                    if(node.containsKey((char)(j + 'a')))
                    {
                        if(totalSearch(node.get((char) (j + 'a')) ,word , i + 1)) return true;
                    }
                }
                return false;
            }
            else{
                if(!node.containsKey(word.charAt(i))) return false;
                node = node.get(word.charAt(i));
            }
        }
        return (node.isEnd());
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */