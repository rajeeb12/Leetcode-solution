class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int lastSmaller = (int)1e9;
        int longestSeq = 0;
        int size= nums.length;
        for(int i =0 ; i < size; i++)
        {
            if(nums[i] - 1 == lastSmaller)
            {
                count++;
                lastSmaller = nums[i];
            }else if(nums[i] != lastSmaller)
            {
                count=1;
                lastSmaller = nums[i];
            }
            longestSeq = Math.max(longestSeq, count);
        }
        return longestSeq;
    }
}