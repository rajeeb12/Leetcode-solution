class Solution {
    public int minSwaps(int[] nums) {
        int minswap = (int)1e9;
        int sum = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
        }
        int csum = 0;
        int i;
        for(i = 0; i < sum; i++){
            csum += nums[i];
        }

        minswap = Math.min(minswap , sum - csum);
        int j = sum; 
        
        for(i = 0; i < n; i++){
            csum += nums[j % n];
            csum -= nums[i];
            System.out.println(csum+" ");
            minswap = Math.min(minswap, sum - csum);
            j++;
        }
        return minswap;

    }
}