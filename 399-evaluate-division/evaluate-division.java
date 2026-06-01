class Pair{
    String v;
    double value;
    public Pair(String _v,double _value){
        this.v = _v;
        this.value = _value;
    }
}
class Solution {
    double ans[];
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        ans = new double[queries.size()];
        Arrays.fill(ans, -1);
        HashMap<String,List<Pair>> map = new HashMap<>();
        for(int i = 0; i < equations.size(); i++){
            List<String> eq = equations.get(i);
            String u = eq.get(0);
            String v = eq.get(1);
            double value = values[i];
            if(!map.containsKey(u)){
                map.put(u, new ArrayList<>());
            }
            if(!map.containsKey(v)){
                map.put(v, new ArrayList<>());
            }
            map.get(u).add(new Pair(v, value));
            map.get(v).add(new Pair(u, 1 / value));
        }
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            String u = query.get(0);
            String v = query.get(1);
            if(!map.containsKey(u) || !map.containsKey(v)){
                ans[i] = -1.0;
                continue;
            }
            dfs(u, v, map, 1.0,new HashSet<>(), i);
        }
        return ans;
    }
    public void dfs(String u,String dest,HashMap<String,List<Pair>> map,double prod,HashSet<String> set,int index){
        if(dest.equals(u)){
            ans[index] = prod;
            return;
        }
        
        set.add(u);

        List<Pair> adjNodes = map.get(u);
        
        for(Pair pair: adjNodes){
            String v = pair.v;
            double value = pair.value;
            if(!set.contains(v)){
                dfs(v, dest, map,(double) prod * value, set,index);
            }
        }
        set.remove(u);

    }
}