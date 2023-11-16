class Solution {
    public String findDifferentBinaryString(String[] nums) {
        String result ="";
        for(int i = 0 ; i < nums.length; i++){
            if(nums[i].charAt(i) == '1'){
                result += '0'; 
            }else{
                result += '1';
            }
        }
        return result;
    }
}