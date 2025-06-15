class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n  = nums.length;
        int arr[][] = new int[n][2];
        arr[n - 1][0] = nums[n - 1];
        arr[n - 1][1] = nums[n - 1];

        for(int i = n - 2; i >= 0; i--){
            arr[i][0] = Math.max(arr[i + 1][0] , nums[i]);
            arr[i][1] = Math.min(arr[i + 1][1] , nums[i]);
        }

        long ans = -(long)1e18;
        for(int i = 0; i <= n - m; i++){
            long first = (long) arr[i + m - 1][0] * nums[i] * 1L;
            long second = (long) arr[i + m - 1][1] * nums[i] * 1L;
            if(first >= second && first >= ans){
                ans = first;
            }else if(second > first && second > ans){
                ans = second;
            }
        }
        return ans;
    }
}