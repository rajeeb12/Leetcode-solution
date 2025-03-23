class Pair{
    String str;
    int level;
    public Pair(String _str,int _level){
        this.str = _str;
        this.level = _level;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word: wordList){
            set.add(word);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));

        int ans = (int)1e9;

        while(!q.isEmpty()){
            Pair temp = q.poll();
            if(temp.str.equals(endWord)){
                ans = Math.min(ans, temp.level);
            }
            char arr[] = temp.str.toCharArray();
            
            for(int i = 0; i < arr.length; i++)
            {
                char prev = arr[i];
                for(char ch= 'a'; ch <= 'z'; ch++){
                    arr[i] = ch;
                    String word = new String(arr);
                    if(set.contains(word)){
                        q.add(new Pair(word, temp.level + 1));
                        set.remove(word);
                    }
                }
                arr[i] = prev;
            }
        }
        if(ans == (int)1e9) return 0;
        return ans;

    }
}