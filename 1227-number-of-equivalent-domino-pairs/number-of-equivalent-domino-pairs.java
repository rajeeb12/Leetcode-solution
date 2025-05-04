class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i[]: dominoes){
            int num = Math.min(i[0], i[1]) * 10 + Math.max(i[0],i[1]);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int value = e.getValue();
            ans += (value * (value - 1)) / 2;
        }
        return ans;
    }
}