class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            int sum = 0;
            for(int j = i; j < n; j++){
                sum += nums[j];
                temp.add(sum);
            }
        }
        Collections.sort(temp);
        int sum = 0; 
        int mod = (int)1e9 + 7;
        for(int i = left - 1 ; i < right; i++){
            sum = (sum + temp.get(i)) % mod;
        }
        return sum;
    }
}