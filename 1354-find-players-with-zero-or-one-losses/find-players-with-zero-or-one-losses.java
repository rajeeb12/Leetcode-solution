class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> wMap = new HashMap<>();
        HashMap<Integer,Integer> lMap = new HashMap<>();
        for(int i[]: matches)
        {
            int w = i[0];
            int l = i[1];
            wMap.put(w, wMap.getOrDefault(w, 0) + 1);
            if(!lMap.containsKey(w)) lMap.put(w,0);

            lMap.put(l, lMap.getOrDefault(l, 0) + 1);
            if(!wMap.containsKey(l)) wMap.put(l,0);
        }
        List<Integer> won = new ArrayList<>();
        List<Integer> loss = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry: wMap.entrySet())
        {
            int key = entry.getKey();
            int totalWon = entry.getKey();
            int totalLoss = lMap.get(key);

            if(totalWon > 0  && totalLoss == 0)
            {
                won.add(key);
            }else if((totalWon > 0 || totalWon == 0) && totalLoss == 1)
            {
                loss.add(key);
            }
        }
        Collections.sort(won);
        Collections.sort(loss);

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(won));
        ans.add(new ArrayList<>(loss));
        return ans;
    }
}