class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countFive = 0, countTen = 0;
        for(int bill: bills)
        {
            if(bill == 5){
                countFive++;
            }else if(bill == 10){
                if(countFive < 1) return false;
                countFive--;
                countTen++;
            }else{
                if(countTen >= 1 && countFive >= 1){
                    countTen--;
                    countFive--;
                }else if(countFive >= 3){
                    countFive -= 3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}