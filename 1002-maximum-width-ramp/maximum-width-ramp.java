class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int max[] = new int[n];
        max[n - 1] = nums[n - 1];
        for(int i = n - 2; i >= 0; i--){
            max[i] = Math.max(max[i + 1] , nums[i]);
        }

        int p1 = 0;
        int ans = 0;
        for(int p2 = 1; p2 < n; p2++){
            
            while(p1 < p2 && nums[p1] > max[p2]) p1++;

            ans = Math.max(ans, p2 - p1);  
        }
        return ans;
    }
}