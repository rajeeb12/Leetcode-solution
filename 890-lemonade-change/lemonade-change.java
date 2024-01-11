class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0;
        int countTen = 0;

        for(int i : bills)
        {
            if(i == 5)
            { 
                countFive++;
            }
            else if(i == 10)
            {
                 countFive--; countTen++;
            }
            else if(countTen > 0)
            {
                 countTen--; countFive--;
            }
            else{
                countFive -= 3;
            }

            if(countFive < 0) return false;

        }
        return true;
    }
}