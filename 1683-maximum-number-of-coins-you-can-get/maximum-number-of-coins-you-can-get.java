class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length;
        int sum = 0;
        int bob = 0;
        int me = n - 2;
        while(bob <= me){
            sum += piles[me];
            bob++;
            me -= 2;
        }
        return sum;
    }
}