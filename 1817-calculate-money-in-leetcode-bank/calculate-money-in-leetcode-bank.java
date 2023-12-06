class Solution {
    public int totalMoney(int n) {
        int totalSum = 0;
        int monday = 1;
        int day = 1;
        for(int i = 1; i <= n; i++)
        {
            totalSum += day;
            day++;
            if(day - monday == 7)
            {
                ++monday;
                day = monday;
            }
        }
        return totalSum;
    }
}