class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, ans, new ArrayList<>());
        return ans;
    }
    public void solve(int index,int[] nums,List<List<Integer>> ans,List<Integer> temp)
    {
        ans.add(new ArrayList<>(temp));

        for(int i = index; i < nums.length; i++)
        {
            if(i != index && nums[i] == nums[i - 1]) continue;

            temp.add(nums[i]);
            solve(i + 1, nums, ans, temp);
            temp.remove(temp.size() - 1);
        }
    }
}