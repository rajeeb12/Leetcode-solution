class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0] , nums[1]);

        List<Integer> arr = new ArrayList<>();
        List<Integer> brr = new ArrayList<>();

        for(int i = 0; i < n; i++){
            if(i != 0) brr.add(nums[i]);
            if(i != n - 1) arr.add(nums[i]);
        }
        return Math.max(solve(n - 1, arr), solve(n - 1, brr));
    }
    public int solve(int n, List<Integer> arr)
    {
        int prev1 = Math.max(arr.get(0) , arr.get(1)), prev2 = arr.get(0);

        for(int i = 2; i < n; i++){
            int notPick = prev1;
            int pick = arr.get(i) + prev2;
            int cur = Math.max(notPick, pick);
            prev2 = prev1;
            prev1 = cur;
        }  
        return prev1;
    }
}