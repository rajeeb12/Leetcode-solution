class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        if(n == 2){
            int sum = nums[0] + nums[1];
            return (sum == target ? new int[]{0, 1} : new int[]{-1,-1});
        }
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]) ,  i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}