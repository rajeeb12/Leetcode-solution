class Solution {
    public int minimumOneBitOperations(int n) {
        int arr[] = new int[32];

        arr[0] = 1;
        for(int i = 1; i <= 30; i++){
            arr[i] = 2 * arr[i - 1] + 1;
        }
        boolean sign = true;
        int ans = 0;
        for(int i = 30; i >= 0 ; i--){
            int ith_bit = (1 << i) & n;

            if(ith_bit == 0) continue;
            if(sign){
                ans += arr[i];
            }else{
                ans -= arr[i];
            }
            sign = (sign ? false: true);
        }
        return ans;
    }
}