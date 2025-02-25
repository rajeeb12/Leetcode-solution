class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        long prefixSum[] = new long[n];
        prefixSum[0] = arr[0];
        for(int i = 1; i < n; i++){
            prefixSum[i] += (long) (arr[i] + prefixSum[i - 1]);
        }
        int ans = 0;
        int evenSum = 1;
        int oddSum = 0;
        int mod = (int)1e9 + 7;
        for(int i = 0; i < n; i++)
        {
            if(prefixSum[i] % 2 == 0){
                ans = (ans + oddSum) % mod;
                evenSum++;
            }else{
                ans = (ans + evenSum) % mod;
                oddSum++;
            }
        }
        return ans % mod;
    }
}