class Pair{
    String str;
    int level;
    public Pair(String _s, int _l){
        this.str = _s;
        this.level = _l;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(beginWord , 0));
        Set<String> set = new HashSet<>();
        for(String str : wordList){
            set.add(str);
        }
        set.remove(beginWord);

        while(!q.isEmpty())
        {
            Pair temp = q.poll();
            String str = temp.str;
            int level = temp.level;

            if(str.equals(endWord)) return level + 1;

            for(int i = 0 ; i < str.length() ; i++){
                for(char ch = 'a' ; ch <= 'z' ; ch++)
                {
                    char[] chrArray = str.toCharArray();
                    chrArray[i] = ch;
                    String str2 = new String(chrArray);
                    if(set.contains(str2)){
                        set.remove(str2);
                        q.add(new Pair(str2,level + 1));
                    }
                }
            }
        }
        return 0;
    }
}