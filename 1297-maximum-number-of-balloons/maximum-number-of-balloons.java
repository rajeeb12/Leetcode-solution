class Solution {
    public int maxNumberOfBalloons(String text) {
        int countB = 0;
        int countA = 0;
        int countL = 0;
        int countO = 0;
        int countN = 0;

        for(char ch: text.toCharArray())
        {
            if(ch == 'b')
            {
                countB++;
            }
            if(ch == 'a')
            {
                countA++;
            }
            if(ch == 'l')
            {
                countL++;
            }
            if(ch == 'o'){
                countO++;
            }
            if(ch == 'n')
            {
                countN++;
            }
        }

        countL /= 2;
        countO /= 2;

        return Math.min(countL,Math.min(countA,Math.min(countB, Math.min(countN, countO))));

    }
}