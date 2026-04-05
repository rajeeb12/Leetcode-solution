class Solution {
    public boolean judgeCircle(String moves) {
        int temp1 = 0 , temp2 = 0;
        for(char c: moves.toCharArray()){
            if(c == 'U'){
                temp1++;
            }else if(c == 'D'){
                temp1--;
            }else if(c == 'R'){
                temp2++;
            }else{
                temp2--;
            }
        }
        return (temp1 == 0 && temp2 == 0 ? true: false);
    }
}