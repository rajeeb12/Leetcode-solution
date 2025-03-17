class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int elm = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(count == 0){
                elm = nums[i];
                count = 1; 
            }
            else if(nums[i] == elm){
                count++;
            }else{
                count--;
            }
        }
        return elm;
    }
}