class Pair{
    String s;
    int l;
    public Pair(String _s,int _l)
    {
        this.s = _s;
        this.l = _l;
    }    
}
class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> de = new HashSet<>();
        for(String it: deadends)
        {
            de.add(it);
        }
        if(de.contains("0000") || de.contains(target)) return -1;
        if(target.equals("0000")) return 0;

        String s = "0000";
        Queue<Pair> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        visited.add(s);
        
        q.add(new Pair(s,0));
        int delta[] = {-1, 1};
      
        while(!q.isEmpty())
        {
            int size= q.size();

            for(int j = 0; j < size; j++)
            {
                Pair p = q.poll();
                String str = p.s;

                int level = p.l;

                if(str.equals(target)) return level;

                for(int i = 0; i < 4; i++)
                {
                    StringBuilder temp = new StringBuilder(str);
                    char ch = temp.charAt(i);

                    char in = (ch == '9' ? '0' : (char)(ch + 1));
                    char dec = (ch == '0' ? '9' : (char) (ch - 1));

                    temp.setCharAt(i, in);
                    String t = temp.toString();
                    if(!visited.contains(t) && !de.contains(t))
                    {
                        q.add(new Pair(t, level + 1));
                        visited.add(t);
                    }
                    temp.setCharAt(i, dec);
                    String u = temp.toString();
                    if(!visited.contains(u) && !de.contains(u)){
                        q.add(new Pair(u, level + 1));
                        visited.add(u);
                    }
                }
            }
        }
        return -1;
    }
}