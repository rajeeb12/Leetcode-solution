class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        if(n == 0) return 0;
        
        Arrays.sort(arr);
        if(arr[0] != 1){
            arr[0] = 1;
        }
        int ans = 1;
        for(int i = 1 ; i < n ; i++){
            if((Math.abs(arr[i - 1] - arr[i]) <= 1) == false){
                arr[i] = arr[i-1] + 1;
            }
            ans = Math.max(arr[i], ans);
        }
        return ans;
    }
}