class Solution {
    public int buyChoco(int[] prices, int money) {
        int sm = (int)1e9 , ssm = (int)1e9;
        // just have to find smallest and second smallest prices.

        for(int i: prices)
        {
            if(sm > i)
            {
                ssm = sm;
                sm = i;
            }else if(ssm > i )
            {
                ssm = i;
            }
        }
        return (sm + ssm <= money ? money - (sm + ssm) : money);
    }
}