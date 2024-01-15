class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int losses[] = new int[100001];

        for(int i[]: matches)
        {
            int w = i[0];
            int l = i[1];

            if(losses[w] == 0) // first time won
            {
                losses[w] = -1;
            }

            if(losses[l] == -1) // lossing first time;
            {
                losses[l] = 1;
            }else{
                losses[l]++;
            }
        }
        List<Integer> won = new ArrayList<>();
        List<Integer> lost = new ArrayList<>();
        for(int i = 1; i < losses.length; i++)
        {
            if(losses[i] == -1)
            {
                won.add(i);
            }else if(losses[i] == 1) // lost only once
            {
                lost.add(i);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(won));
        ans.add(new ArrayList<>(lost));
        return ans;
    }
}