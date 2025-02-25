class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        long prefixSum = 0;
        int evenCount = 1;
        int oddCount = 0;
        int ans = 0, mod = (int)1e9 + 7;
        for(int i = 0; i < n; i++){
            prefixSum += arr[i];
            if(prefixSum % 2 == 0){
                ans = (ans + oddCount) % mod;
                evenCount++;
            }else{
                ans = (ans + evenCount) % mod;
                oddCount++;
            }
        }
        return ans % mod;
    }
}