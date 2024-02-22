class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, ans, nums);
        return ans;
    }
    public void solve(int index,List<List<Integer>> ans, int[] nums)
    {
        if(index == nums.length)
        {
            List<Integer> temp = new ArrayList<>();
            for(int i: nums)
            {
                temp.add(i);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = index; i < nums.length; i++)
        {
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(index, i, nums);
            solve(index + 1, ans, nums);
            swap(index ,i, nums);
        }
    }
    public void swap(int i,int j,int[] A)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}