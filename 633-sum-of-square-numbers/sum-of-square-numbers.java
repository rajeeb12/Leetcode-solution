class Solution {
    public boolean judgeSquareSum(int c) {
        long i = 0 , j = (long) Math.sqrt(c);

        while(i <= j){
            long prod = i * i + j * j;
            if(prod == c) return true;
            if(prod > c){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}