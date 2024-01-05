class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int left = 0, right = n - k;
        int res = 0;
        for(int i = right ; i < n ; i++)
        {
            res += cardPoints[i];
        }
        int total = res;
        while(right < n)
        {
            total += (cardPoints[left] - cardPoints[right]); 
            res = Math.max(res, total);
            right++;
            left++;
        }
        return res;
    }
}