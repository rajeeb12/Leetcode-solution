class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);
        int n = nums.length;
        if(n == 1 || n == 0) return n;
    
        int max = 1;
        for(int i : nums)
        {
            if(!set.contains(i - 1))
            {
                int cur = i;
                int count = 0;
                while(set.contains(cur))
                {
                    count++;
                    cur++;
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
}