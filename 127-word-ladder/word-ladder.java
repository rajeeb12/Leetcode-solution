class Pair{
    String str;
    int level;
    public Pair(String _s,int _l)
    {
        this.str = _s;
        this.level = _l;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        for(String s: wordList)
        {
            set.add(s);
        }
        q.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while(!q.isEmpty())
        {
            int size= q.size();

            for(int i = 0 ; i < size; i++)
            {
                Pair p = q.poll();
                String s = p.str;
                int level = p.level;

                if(s.equals(endWord)) return level;

                for(int j = 0 ; j < s.length(); j++)
                {
                    for(char ch= 'a' ; ch <= 'z'; ch++)
                    {
                        char[] charArray = s.toCharArray();
                        charArray[j] = ch;
                        String str = new String(charArray);
                        if(set.contains(str))
                        {
                            set.remove(str);
                            q.add(new Pair(str, level + 1));
                        }
                    }
                }
            }
        }
        return 0;
    }
}