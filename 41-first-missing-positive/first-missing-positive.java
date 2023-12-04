class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        
        for(int i: nums)
        {
            if(i == -1 || i == 0) continue;
            set.add(i);
        }

        for(int i = 1; i <=nums.length; i++)
        {
            if(!set.contains(i)) return i;
        }
        return nums.length + 1;
    }
}