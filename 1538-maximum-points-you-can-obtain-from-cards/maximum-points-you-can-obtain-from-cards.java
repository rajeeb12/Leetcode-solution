class Solution {
    public int maxScore(int[] C, int k) {
        int total = 0;
        int n = C.length;
        if(k > n) return 0;

        int left = 0 , right = n - k;
        int currSum = 0;
        while(right < n)
        {
            currSum += C[right];
            right++;
        }

        int res = currSum;
        right = n - k;
        while(right < n)
        {
            currSum += (C[left] - C[right]);
            res = Math.max(res, currSum);
            right++;
            left++;
        }
        return res;
    }
}