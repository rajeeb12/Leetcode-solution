class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int p = 1;
        int ans[] = new int[n];
        // pehele put then multiply 
        for(int i = 0 ; i < n ; i++){
            ans[i] = p;
            p *= nums[i];
        }
        p = 1;
        // pehele put then multiplu 
        for(int i = n - 1; i >= 0 ;i--){
            ans[i] *= p;
            p *= nums[i];
        }
        return ans;
    }
}
// used extra space
// public int[] productExceptSelf(int[] nums) {
//         int n = nums.length;
//         int prefix[]= new int[n];
//         int suffix[]= new int[n];
//         int p = 1;
//         for(int i = 0 ; i < n ; i++){
//             p *= nums[i];
//             prefix[i] = p;
//         }
//         int s = 1;
//         for(int i = n-1 ; i >= 0 ; i--){
//             s *= nums[i];
//             suffix[i] = s;
//         }
//         int ans[]= new int[n];
//         for(int i = 0 ; i < n ; i++){
//             if(i <= 0){
//                 ans[i] = suffix[i + 1];
//                 continue;
//             }
//             if(i == n - 1){
//                 ans[i] = prefix[i-1];
//                 continue;
//             }
//             ans[i] = prefix[i-1] * suffix[i + 1];
//         }
//         return ans;
//     }