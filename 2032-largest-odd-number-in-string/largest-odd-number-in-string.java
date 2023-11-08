class Solution {
    public String largestOddNumber(String num) {
        int n = num.length();
        if((num.charAt(n-1) - '0') % 2 != 0) return num;

        for(int i = n - 2; i >=0 ; i--){
            int number = num.charAt(i) - '0';
            if(number % 2 != 0) return num.substring(0, i+1);
        }
        return "";
    }
}