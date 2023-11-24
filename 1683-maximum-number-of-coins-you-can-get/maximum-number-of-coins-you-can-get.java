class Solution {
    public int maxCoins(int[] piles) {
        int i = 0 ;
        int m = piles.length-2;
        int a = piles.length-1;
        Arrays.sort(piles);
        int sum = 0;
        while(m > i)
        {
            sum += piles[m];
            m -= 2;
            a -= 2;
            i++;
        }
        return sum;
    }
}