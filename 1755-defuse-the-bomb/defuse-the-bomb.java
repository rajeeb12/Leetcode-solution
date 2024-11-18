class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int prefix[] = new int[n + n];
        int suffix[] = new int[n + n];
        int len = 2 * n;
        prefix[0] = code[0];
        for(int i = 1; i < len; i++){
            prefix[i] += prefix[i - 1] + code[i % n];
        }
        suffix[len - 1] = code[n - 1];

        for(int i = len - 2; i >=0 ; i--){
            suffix[i] += suffix[i + 1] + code[i >= n ? (i - n) : i]; 
        }
        int ans[] = new int[n];
        
        if(k == 0){
            Arrays.fill(ans, 0);
            return ans;
        }
        return solve(code, suffix, prefix,k, ans);
    }
    public int[] solve(int[] code,int[] suffix,int[] prefix,int k,int ans[]){
        int n = code.length;
        int _k = k;
        for(int i = 0; i < n; i++){
            if(k < 0){
                int index = i + n;
                ans[i] = suffix[index + _k] - suffix[i + n]; 
            }else{ 
                ans[i] = prefix[i + k] - prefix[i];
            }
        }
        return ans;
    }
}