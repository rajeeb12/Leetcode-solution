class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];
        if(k < 0){
            return solvePrev(code, -k, ans);
        }else if(k > 0){
            return solveNext(code, k, ans);
        }
        Arrays.fill(ans, 0);
        return ans;
    }
    public int[] solveNext(int code[],int k,int ans[]){
        int n = code.length;

        for(int i = 0; i < n; i++){
            int _k = k;
            int sum = 0;
            int j = i + 1;
            while(_k > 0){
                sum += code[j % n];
                j++;
                _k--;
            }
            ans[i] = sum;
        }
        return ans;
    }
    public int[] solvePrev(int code[],int k,int ans[]){
        int n = code.length;

        for(int i = 0; i < n; i++){
            int _k = k;
            int sum = 0;
            int j = i - 1;
            while(_k > 0){
                sum += code[(j + n) % n];
                j--;
                _k--;
            }
            ans[i] = sum;
        }
        return ans;
    }

}