class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int maxMoneySave = -(int)1e9;
        for(int right = prices.length - 1; right >= 1; right--)
        {
            int sum = prices[right] + prices[0];
            maxMoneySave = Math.max(maxMoneySave, money - sum);
        }
        return (maxMoneySave < 0 ? money : maxMoneySave);
    }
}