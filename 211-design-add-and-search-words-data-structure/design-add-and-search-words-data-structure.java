class Node{
    Node link[];
    boolean flag;
    public Node()
    {
        link = new Node[26];
        flag = false;
    }
    public void put(char ch, Node node)
    {
        link[ch-'a'] = node;
    }
    public boolean containsKey(char ch)
    {   
        return (link[ch -'a' ] != null);
    }
    public Node get(char ch)
    {
        return link[ch-'a'];
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
class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node node = root;
        int n = word.length();
        for(int i = 0 ; i < n; i++)
        {
            char ch = word.charAt(i);
            if(!node.containsKey(ch))
            {
                node.put(ch, new Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node = root;
       return searchUtil(node,word);
    }
    public boolean searchUtil(Node n, String word)
    {
        Node node = n;
        int len = word.length();
        for(int i = 0 ; i < word.length(); i++)
        {
            char ch = word.charAt(i);
            if(ch == '.')
            {
                for(char j = 'a' ; j <= 'z'; j++)
                {
                    if(node.containsKey(j))
                    {
                        if(searchUtil(node.get(j), word.substring(i + 1, len)))
                        {
                            return true;
                        }
                    }
                }
                return false;
            }
            else if(!node.containsKey(ch))
            {
                System.out.print(ch);
                return false;
            }
            node = node.get(ch);
        }
        return (node.isEnd() ? true : false);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */