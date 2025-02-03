class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if(nums.length == 1) return 1;
        int maxLongest = 0;

        for(int i = 0; i < nums.length - 1; i++){
            int longest = 1;
            for(int j = i; j < nums.length - 1; j++){
                if(nums[j] < nums[j + 1]) longest++;
                else break;
            }
            maxLongest = Math.max(maxLongest, longest); 
        }
        int minLongest = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int min = 1;
            for(int j = i; j < nums.length - 1; j++){
                if(nums[j] > nums[j + 1]) min++;
                else break;
            }
            minLongest = Math.max(minLongest, min); 
        }
        return Math.max(maxLongest, minLongest);
    }
}