class Solution {
    public String largestGoodInteger(String nums) {
        if(nums.equals("")) return "";

        int size = nums.length();
        int count = 1;
        int maxNumber = -(int)1e9;
        for(int i = 1 ; i <size; i++)
        {
            if(nums.charAt(i) == nums.charAt(i - 1))
            {
                count++;
            }
            else{
                count = 1;
            }
            if(count >= 3)
            {
                maxNumber = Math.max(maxNumber , nums.charAt(i) - '0');
            }
        }

        if(maxNumber == (-(int)1e9)) return "";
        String ans = maxNumber +""+maxNumber +""+maxNumber;
        return ans;
    }
}