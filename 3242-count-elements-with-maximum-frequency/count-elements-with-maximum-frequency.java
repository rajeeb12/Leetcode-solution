class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums)
        {
            map.put(i,map.getOrDefault(i, 0 ) + 1);
        }
        int maxFreq = 0;
        int count = 0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            int value = entry.getValue();
            if(value > maxFreq)
            {
                maxFreq = value;
            }
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            int value = entry.getValue();
            if(value == maxFreq)
            {
                count++;
            }
        }
        return count * maxFreq;
    }
}