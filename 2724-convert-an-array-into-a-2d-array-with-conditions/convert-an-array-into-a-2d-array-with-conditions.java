class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int hash[] = new int[n + 1]; 

        for(int i: nums)
        {
            hash[i]++;
        }

        while(true)
        {
            int count = 0;
            List<Integer> temp = new ArrayList<>();
            for(int i = 1 ; i <= n; i++)
            {
                if(hash[i] == 0)
                {
                    count++;
                    continue;
                }
                temp.add(i);
                hash[i]--;
            }
            if(count == n) break;
            ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}