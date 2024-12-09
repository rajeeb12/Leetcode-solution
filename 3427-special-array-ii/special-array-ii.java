class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int map[] = new int[(int)1e6];
        int n = nums.length;
        for(int i = 0; i < n - 1; i++){
            int p1 = nums[i] & 1;
            int p2 = nums[i + 1] & 1;
            if(p1 == p2){
                map[i]++;
            }
        }
        for(int i = 1; i < (int)1e6; i++){
            map[i] += map[i - 1]; 
        }
        boolean ans[] =new boolean[queries.length];
        int index = 0;
        for(int q[]: queries)
        {
            if(q[0] == q[1]){
                ans[index] = true;
                index++;
                continue;
            }
            int val = 0;
            if(q[0] - 1 >= 0){
                val = map[q[1] - 1] - map[q[0] - 1]; 
            }else{
                val = map[q[1] - 1];
            }
            ans[index] = (val > 0 ? false : true);
            index++;
        }
        return ans;
    }
}