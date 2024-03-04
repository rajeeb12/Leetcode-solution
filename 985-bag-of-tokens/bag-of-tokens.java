class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int  i = 0 , j = tokens.length - 1;
        int max = 0;
        while(i <= j)
        {
            if(power >= tokens[i])
            {
                ++score;
                power -= tokens[i];
                max = Math.max(max, score);
                i++;
            }else if(score >= 1)
            {
                score--;
                power += tokens[j];
                j--;
            }
            else{
                break;
            }
        }
        return max;
    }
}