class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int ans[] = new int[n];
        int ca[] = new int[51];
        int cb[] = new int[51];

        for(int i = 0; i < n; i++){
            ca[A[i]]++;
            cb[B[i]]++;
            int count = 0;
            for(int j = 0; j < 51; j++){
                if(ca[j] != 0 && cb[j] != 0) count++;
            }
            ans[i] = count;
        }
        return ans;
    }
}