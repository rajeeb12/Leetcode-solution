class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int mxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            mxProfit = Math.max(mxProfit, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        } 
        return mxProfit;
    }
}