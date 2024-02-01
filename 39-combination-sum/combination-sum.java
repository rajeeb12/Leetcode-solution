class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,candidates,target, new ArrayList<>(), ans);
        return ans;
    }
    public void solve(int index,int[] c,int t,ArrayList<Integer> temp,List<List<Integer>> ans )
    {
        if(t < 0) return;
        if(index == c.length)
        {
            if(t == 0)
            {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        temp.add(c[index]);
        solve(index, c, t - c[index], temp, ans);
        temp.remove(temp.size() - 1);
        solve(index + 1, c,t, temp, ans);
    }
}