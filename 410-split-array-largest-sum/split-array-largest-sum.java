class Solution {
    public int splitArray(int[] nums, int k) {
        int low = -(int)1e9;
        int high = 0;

        for(int i: nums){
            low = Math.max(i, low);
            high += i;
        }

        while(low <= high){
            int mid = (low + high) >> 1;
            int count = getCount(mid , nums);
            if(count > k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }
    public int getCount(int mid, int[] nums){
        int count1 = 1;
        int total = 0;

        for(int i = 0; i < nums.length ; i++){
            if(total + nums[i] > mid){
                count1++;
                total = nums[i];
            }else{
                total += nums[i];
            }
        }
        return count1;
    }
}