class Solution {
    public static void solve(String s,int index,List<List<String>> res,List<String> ds)
    {
        if(index==s.length())
        {
            res.add(new ArrayList<>(ds));
            return;
        }
        
        for(int i = index; i<s.length(); i++)
        {
            if(check(s,index,i))
            {
                ds.add(s.substring(index,i+1));
                solve(s,i+1,res,ds);
                ds.remove(ds.size()-1);
            }
        }
    }
    public static boolean check(String s,int start,int end)
    {
        while(start <= end)
        {
            if(s.charAt(start++)!= s.charAt(end--))
                return false;
        }
        return true;
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res= new ArrayList<>();
        List<String> ds= new ArrayList<>();
        solve(s,0,res,ds);
        return res;
    }
}