class Solution {
    public int maxProfit(int[] prices) {
        int min = (int) 1e9;
        int maxProfit = 0;
        for(int price: prices){
            min = Math.min(min, price);
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;
    }
}