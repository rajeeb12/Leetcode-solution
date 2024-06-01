class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        
        int n = arr.length;
        int prefix[] = new int[n + 1];
        prefix[1] = arr[0];
        for(int i = 1; i < n; i++){
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        int ans = 0;
        for(int i = 0; i <= n; i++){
            for(int k = i + 1; k <= n; k++){
                if(prefix[i] == prefix[k]){
                    ans += k - i - 1;
                }
            }
        }
        return ans;   
    } 
}