class Trie{
    Trie[] node;
    int count;
    public Trie(){
        node = new Trie[26];
        count = 0;
    }
}
class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie root = new Trie();
        Trie cur = root;
        for(String s: words)
        {
            cur = root;
            for(char c: s.toCharArray()){
                if(cur.node[c-'a'] == null){
                    cur.node[c-'a'] = new Trie();
                    cur = cur.node[c-'a'];
                }else{
                    cur = cur.node[c-'a'];
                }
                cur.count++;
            }
        }
        int ans[] = new int[words.length];

        for(int i = 0 ; i < words.length; i++)
        {
            String s = words[i];
            int sum = 0;
            cur = root;
            for(char c: s.toCharArray())
            {
                cur = cur.node[c-'a'];
                sum += cur.count;
            }
            ans[i] = sum;
        }
        return ans;
    }
}