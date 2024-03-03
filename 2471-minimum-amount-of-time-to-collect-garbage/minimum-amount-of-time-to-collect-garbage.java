class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        for(int i = 1; i < travel.length; i++)
        {
            travel[i] += travel[i - 1];
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0; i < garbage.length; i++)
        {
            String str = garbage[i];
            sum += str.length();
            for(char ch: str.toCharArray())
            {
                map.put(ch, i);
            }
        }
        for(Integer it: map.values())
        {
            if(it == 0) continue;
            sum += travel[it - 1];
        }
        return sum;
    }
}