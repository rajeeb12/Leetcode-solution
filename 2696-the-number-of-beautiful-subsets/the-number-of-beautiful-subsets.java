class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return solve(0,nums,k,map) - 1;
    }
    public int solve(int index,int[] nums,int k,HashMap<Integer,Integer> map)
    {
        if(index == nums.length){
            return 1;
        }
        int notPick = solve(index + 1, nums, k,map);
        int pick = 0;
        if(!map.containsKey(nums[index] + k) && !map.containsKey(nums[index] - k)){
            map.put(nums[index], map.getOrDefault(nums[index] , 0 ) + 1);
            
            pick = solve(index + 1, nums, k, map);
            
            map.put(nums[index], map.get(nums[index]) - 1);

            if(map.get(nums[index]) == 0) map.remove(nums[index]);
        }
        return pick + notPick;
    }
}