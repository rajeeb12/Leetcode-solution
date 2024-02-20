class Solution {
    public int missingNumber(int[] nums) {
        int xs1= 0;

        for(int i = 0 ; i <= nums.length; i++)
        {
            xs1 ^= i; 
        } 
        int xs2 = 0; 
        for(int i: nums)
        {
            xs2 ^= i; 
        }
        return xs2 ^ xs1;
    }
}