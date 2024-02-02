class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,n,nums,ans);
        return ans;
    }
    public void solve(int index,int n,int[] nums,List<List<Integer>> ans)
    {
        if(index == n)
        {
            List<Integer> temp = new ArrayList<>();
            for(int i: nums)
            {
                temp.add(i);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = index; i < n; i++)
        {
            swap(index, i, nums);
            solve(index + 1, n, nums, ans);
            swap(index, i, nums);
        }
    }
    public void swap(int i,int j,int[] nums)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}