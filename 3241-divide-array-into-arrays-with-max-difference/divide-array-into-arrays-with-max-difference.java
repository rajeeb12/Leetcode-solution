class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        if(n % 3 != 0)
        {
            return new int[][]{};
        }
        for(int i = 0 ; i < n; i += 3)
        {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            
            if((b - a) > k || (c - b) > k || (c - a) > k)
            {
                return new int[][]{};
            }
        }
        ArrayList<ArrayList<Integer>> tempans = new ArrayList<>();
        for(int i = 0 ; i < n ; i += 3)
        {
            int a = nums[i];
            int b = nums[i + 1];
            int c = nums[i + 2];
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(a);
            temp.add(b);
            temp.add(c);
            tempans.add(new ArrayList<>(temp));
        }
        int ans[][] = new int[tempans.size()][3];
        int index = 0;
        for(ArrayList<Integer> it: tempans)
        {
            ans[index][0] = it.get(0);
            ans[index][1] = it.get(1);
            ans[index][2] = it.get(2);
            index++;
        }
        return ans;
    }
}