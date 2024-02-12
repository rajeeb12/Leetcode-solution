class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int count = 0;
        for(int i: nums)
        {
            if(i % 2 == 0) count++;
        }
        return (count >= 2 ? true: false);
    }
}