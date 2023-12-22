class Node{
    Node links[]= new Node[26];
    boolean flag = false;

    boolean containsKey(char ch)
    {
        return (links[ch - 'a'] != null);
    }
    Node get(char ch)
    {
        return links[ch- 'a'];
    }

    public void put(char ch, Node node)
    {
        links[ch - 'a'] = node;
    }
    public void setEnd()
    {
        flag = true; 
    }
    public boolean isEnd()
    {
        return flag;
    }
}
class Trie {
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(char i : word.toCharArray())
        {
            if(!node.containsKey(i))
            {
                node.put(i, new Node());
            }
            node = node.get(i);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root; 
        for(char i : word.toCharArray())
        {
            if(!node.containsKey(i))
            {
                return false;
            }
            node = node.get(i);
        }
        if(node.isEnd())
        {
            return true;
        }
        return false;
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(char i: prefix.toCharArray())
        {
            if(!node.containsKey(i)){
                return false;
            }
            node = node.get(i);
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