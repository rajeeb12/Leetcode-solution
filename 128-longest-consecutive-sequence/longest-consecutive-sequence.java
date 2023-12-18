class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int i: nums)
        {
            set.add(i);
        }
        int count = 1;
        int max = 0;
        for(int i: nums)
        {
            if(!set.contains(i - 1))
            {
                int number = i + 1;
                count = 1;
                while(set.contains(number))
                {
                    number++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}