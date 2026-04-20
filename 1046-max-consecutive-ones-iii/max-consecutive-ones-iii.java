class Solution {
    public int longestOnes(int[] nums, int k) {
        int i = 0, countZero = 0, countOne = 0, max = 0;

        for(int j = 0; j < nums.length; j++){
            if(nums[j] == 1){
                countOne++;
            }else{
                countZero++;
            }
            while(countZero > k){
                countOne -= (nums[i] == 1 ? 1 : 0);
                countZero -= (nums[i] == 0 ? 1 : 0);
                i++;
            }
            max = Math.max(max, countOne + countZero);
        }
        return max;
    }
}