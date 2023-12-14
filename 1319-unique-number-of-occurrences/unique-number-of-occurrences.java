class Solution {
    public boolean uniqueOccurrences(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i], 0) + 1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            int value = entry.getValue();
            if(set.contains(value)) return false;
            else{
                set.add(value);
            }
        }
        return true;
    }
}