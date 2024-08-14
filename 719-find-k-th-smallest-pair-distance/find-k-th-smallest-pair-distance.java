class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        Arrays.sort(nums);

        int left = 0 , right = nums[n - 1] - nums[0], ans = 0;
        while(left <= right){
            int mid = (left + right) >> 1;
            int value = getValue(mid, nums, k);
            if(value < k)
            {
                left = mid + 1;
            }else{
                ans = mid;
                right = mid - 1;
            }
        } 
        return ans;
    }
    public int getValue(int distance,int nums[],int k){
        int i = 0, j = 1, count = 0;
        
        while(j < nums.length){
            int diff = nums[j] - nums[i];
            if(diff <= distance){
                count += j - i;
                j++;
            }else{
                i++;
            }
        }

        return count;
    }
}