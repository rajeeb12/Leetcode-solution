class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int i: arr) {
            set.add(i);
            max = Math.max(max, i);
        }
        int count = 0;
        int ans = -1;
        int num = 1;
        while(true)
        {
            if(!set.contains(num))
            {
                count++;
            }
            if(count == k)
            {
                ans = num;
                break;
            }
            num++;
        }
        return ans;
    }
}