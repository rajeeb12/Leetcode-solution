class Pair{
    int first;
    int second;
    public Pair(int _f,int _s){
        this.first = _f;
        this.second = _s;
    }
}

class Solution {
    long dp[];
    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        for(int i: power){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Pair> ls = new ArrayList<>();

        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            ls.add(new Pair(e.getKey(), e.getValue()));
        }
        dp = new long[ls.size() + 1];
        Arrays.fill(dp, -1);

        return solve(0,ls);
    }
    public long solve(int index,List<Pair> ls){
        if(index == ls.size()) return 0;
        
        if(dp[index] != -1) return dp[index];

        long notPick = solve(index + 1, ls);
        long pick = 0;
        int nextIndex = index;
        
        while(nextIndex < ls.size() && ls.get(nextIndex).first - ls.get(index).first <= 2) nextIndex++;
        
        pick = (long) ls.get(index).first * ls.get(index).second + solve(nextIndex, ls);

        return dp[index] = (long) Math.max(notPick , pick);
    }
}