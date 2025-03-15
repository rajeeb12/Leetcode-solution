class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int left = (int)1e9;
        int right = -(int)1e9;
        for(int i: nums)
        {
            left = Math.min(left, i);
            right = Math.max(right, i);
        }
        int ans = -1;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(check(mid, nums, k)){
                ans = mid;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }
    public boolean check(int capability,int nums[],int k){
        int count = 0;
        for(int i = 0; i < nums.length;){
            if(capability >= nums[i]){
                count++;
                i += 2;
            }else{
                i++;
            }
        }
        return (count >= k);
    }
    
}