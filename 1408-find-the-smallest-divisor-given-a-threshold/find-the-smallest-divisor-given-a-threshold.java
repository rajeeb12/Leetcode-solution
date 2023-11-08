class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high= -(int)1e9;

        for(int i: nums){
            high = Math.max(high , i);
        }
        int ans = -1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(check(mid, threshold, nums)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
    public boolean check(int mid, int limit, int[] nums){
        int sum = 0;

        for(int i =0 ; i< nums.length ; i++){
            sum += Math.ceil(1.0 * nums[i] / mid);
        }
        return sum <= limit;
    }
}