class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                int index = (nums[i] + i) % n;
                result[i] = nums[index];
            }else{
                int index= nums[i] + i;
                if(index < 0){
                    index = (((index + n) % n + n) % n);
                }
                result[i] = nums[index];
            }
        }
        return result;
    }
}