class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = lowerBound(nums, target);
        int right = upperBound(nums, target);

        return new int[]{left, right};
    }
    public int lowerBound(int nums[],int target){
        int low = 0 , high = nums.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(nums[mid] == target){
                ans = mid;
                high = mid - 1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public int upperBound(int nums[],int target){
        int low = 0 , high = nums.length - 1;
        int ans = -1;
        while(low <= high){
            int mid = (low + high) >> 1;
            if(nums[mid] == target){
                ans = mid;
                low = mid + 1;
            }else if(nums[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

}