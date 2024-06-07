class Node{
    Node map[];
    boolean flag;
    public Node(){
        map = new Node[26];
        flag = false;
    }
    public Node get(char c){
        return map[c-'a'];
    }
    public void put(char c, Node node){
        map[c-'a'] = node;
    }
    
    public boolean containsKey(char c){
        return map[c-'a'] != null;
    }
    public void setEnd(){
        flag = true;
    }
    public boolean isEnd(){
        return flag;
    }
}
class Trie{
    private Node root;
    public Trie(){
        root = new Node();
    }

    public void insert(String s){
        Node node = root;

        for(int i = 0; i < s.length(); i++){
            if(!node.containsKey(s.charAt(i))){
                node.put(s.charAt(i) , new Node());
            }
            node = node.get(s.charAt(i));
        }
        node.setEnd();
    }
    public String prefixSearch(String s){
        Node node = root;
        int tindex = -1;
        for(int i = 0; i < s.length(); i++){
            if(node.isEnd() || !node.containsKey(s.charAt(i))) break;
            tindex = i; 
            node = node.get(s.charAt(i));
        }

        if(node.isEnd()){
            return s.substring(0, tindex + 1);
        }
        return s;
    }
}
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for(String s : dictionary){
            root.insert(s);
        }
        String arr[] = sentence.split(" ");
        StringBuilder ans = new StringBuilder("");
        for(String s: arr){
            ans.append(root.prefixSearch(s)+" ");
        }
        return ans.toString().substring(0, ans.length() - 1);
    }
}