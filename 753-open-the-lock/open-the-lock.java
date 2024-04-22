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
        if(de.contains(target) || de.contains("0000")) return -1;
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
                    String temp = str;
                    
                    for(int it : delta)
                    {
                        int val = temp.charAt(i) - '0' + it; 
                        if(val < 0)
                        {
                            val = 9;
                        }else if(val > 9)
                        {
                            val = 0;
                        }
                        
                        String ns = temp.substring(0,i) + (val +"") + temp.substring(i + 1, temp.length());
                        if(!visited.contains(ns) && !de.contains(ns)){
                            visited.add(ns);
                            q.add(new Pair(ns, level + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}