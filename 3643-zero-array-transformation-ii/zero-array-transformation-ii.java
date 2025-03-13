class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0, right = queries.length - 1, ans = -1, sum = 0;
        for(int i: nums) sum += i;
        if(sum == 0) return 0;
        while(left <= right){
            int mid = (left + right) >> 1;
            if(check(mid, nums, queries)){
                ans = mid + 1;
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }   
        return ans;
    }
    public boolean check(int k,int nums[],int queries[][]){
        int diff[] = new int[nums.length + 1];
        for(int i = 0; i <= k; i++){
            diff[queries[i][0]] += queries[i][2];
            diff[queries[i][1] + 1] -= queries[i][2];
        }
        int curSum = 0;
        for(int i = 0; i < nums.length; i++){
            curSum += diff[i];
            if(curSum < nums[i]) return false;
        }
        return true;
    }
}