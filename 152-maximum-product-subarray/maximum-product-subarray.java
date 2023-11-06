class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];

        int maxProd= -(int)1e9;

        for(int i = 0 ; i < n; i++){
            int prod = 1;
            for(int j = i ; j < n; j++){
                prod *= nums[j];
                maxProd = Math.max(maxProd , Math.max(prod, nums[j]));
            }
           
        }
        return maxProd;
    }
}