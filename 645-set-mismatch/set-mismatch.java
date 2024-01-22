class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int map[] = new int[n+1];
        for(int i: nums)
        {
            map[i]++;
        }
        int missing = 0;
        int repeated = 0;
        for(int i = 1 ; i <= n ; i++)
        {
            if(map[i] == 2) repeated = i;
            if(map[i] == 0) missing = i; 
        }
        return new int[]{repeated, missing};
    }
}