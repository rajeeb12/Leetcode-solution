class Solution {
    public boolean judgeSquareSum(int c) {

        long left = 0 , right = (long) Math.sqrt(c);
        while(left <= right)
        {
            long sum = left * left + right * right;
            if(sum > c)
            {
                right--;
            }else if(sum < c)
            {
                left++;
            }else{
                return true;
            }
        }
        return false;
    }
}