class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0 ; i < nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                int j = map.get(target - nums[i]);
                return new int[]{j, i};
            }
            map.put(nums[i] , i);
        }
        return new int[]{-1};
    }
}