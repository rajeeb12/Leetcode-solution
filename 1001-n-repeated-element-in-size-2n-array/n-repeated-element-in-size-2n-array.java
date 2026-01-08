class Solution {
    public int repeatedNTimes(int[] nums) {
        int occurence = nums.length / 2;
        Arrays.sort(nums);
        int count = 0, current = nums[0]; 
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == current){
                count++;
            }
            if(occurence == count){
                return nums[i];
            }
            if(nums[i] != current){
                current = nums[i];
                count = 1;
            }
        }
        return -1;
    }
}