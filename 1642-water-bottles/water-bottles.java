class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles, rem = 0;

        while(true){
            rem = numBottles % numExchange;
            numBottles = numBottles / numExchange;
            ans += numBottles;
            if(numBottles == 0) break;
            numBottles = rem + numBottles;
        }
        return ans;
    }
}