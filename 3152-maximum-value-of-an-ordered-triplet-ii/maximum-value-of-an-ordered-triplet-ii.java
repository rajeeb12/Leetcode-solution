class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long lmax = 0 , opMax = 0, res = 0;

        for(int num: nums){
            res = Math.max(res ,1L * opMax * num);
            opMax = Math.max(opMax, lmax - num);
            lmax = Math.max(lmax, num);
        }

        return res;
    }
}