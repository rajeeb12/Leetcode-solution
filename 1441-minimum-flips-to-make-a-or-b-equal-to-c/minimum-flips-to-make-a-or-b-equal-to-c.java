class Solution {
    public int minFlips(int a, int b, int c) {
        int count = 0;
        for(int i = 0; i < 31; i++){
            int abit = 1 & (a >> i);
            int bbit = 1 & (b >> i);
            int cbit = 1 & (c >> i);
            if(cbit == 0){
                count += abit + bbit;
            }else{
                if(abit == 0 && bbit == 0) count++;
            }
        }
        return count;
    }
}