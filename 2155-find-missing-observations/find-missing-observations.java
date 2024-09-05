class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int ans[] = new int[n];
        int sum = 0;
        for(int i: rolls) sum += i;
        int total = mean * (n + m);
        int diff = total - sum;
        if(6 * n < diff || diff <= 0 || (diff / n) == 0) return new int[]{};

        int p = diff / n, q = diff % n;

        for(int i = 0 ; i < n; i++){
            ans[i] = p + (q > 0 ? 1 : 0);
            q--;
        }
        return ans;

    }
}