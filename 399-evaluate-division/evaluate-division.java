class Pair{
    String v;
    double value;
    public Pair(String _v,double _value)
    {
        this.v = _v;
        this.value = _value;
    }

}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<Pair>> adj = new HashMap<>();
        int n = values.length;
        for(int i = 0; i < n; i++)
        {
            List<String> arr = equations.get(i);
            String value1 = arr.get(0);
            String value2 = arr.get(1);
            adj.putIfAbsent(value1 , new ArrayList<>());
            adj.putIfAbsent(value2 , new ArrayList<>());

            adj.get(value1).add(new Pair(value2, values[i]));
            adj.get(value2).add(new Pair(value1, 1.0 / values[i]));
        }
        double ans[] = new double[queries.size()];
        for(int i = 0 ; i < queries.size(); i++)
        {
            List<String> q = queries.get(i);
            String value1 = q.get(0);
            String value2 = q.get(1);
            if(!adj.containsKey(value1) || !adj.containsKey(value2))
            {
                ans[i] = -1.0;
            }
            else{
                HashSet<String> visit = new HashSet<>();
                double res[]= {-1.0};
                dfs(adj, value1, value2, visit,res,1.0);
                ans[i] = res[0];
            }
        }
        return ans;
    }
    public void dfs(HashMap<String, ArrayList<Pair>> adj,String src, String dest,HashSet<String> visit,double ans[],double temp)
    {
        visit.add(src);

        if(src.equals(dest))
        {
            ans[0] = temp;
            return;
        }

        for(Pair t: adj.get(src))
        {    
            String node = t.v;
            double value = t.value;
            if(!visit.contains(node))
            {
                dfs(adj, node, dest,visit, ans, temp * value);
            }
            
        }
    }
}