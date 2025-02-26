class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int prefix[] = new int[n];
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = nums[i] + prefix[i - 1]; 
        }
        int negMax = 0;
        int posMax = 0;
        int max = 0;
        for(int i = 0; i < n; i++)
        {

            if(prefix[i] < 0){
                max = Math.max(max, (Math.abs(prefix[i]) + posMax));
                negMax = Math.max(negMax, Math.abs(prefix[i]));
            }else{
                max = Math.max(max, prefix[i] + negMax);
                posMax = Math.max(posMax, prefix[i]);
            }
        }
        return max;
    }
}