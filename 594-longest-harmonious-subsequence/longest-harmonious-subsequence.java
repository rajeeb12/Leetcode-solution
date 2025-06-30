class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> right = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            if(right.containsKey(nums[i])){
                right.put(nums[i], right.get(nums[i]) + 1);
            }
            else{
                right.put(nums[i] , 1);
            }
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(right.containsKey(nums[i] - 1)){
                ans = Math.max(ans, right.get(nums[i]) + right.get(nums[i] -  1));
            }
        }
        return ans;
    }
}