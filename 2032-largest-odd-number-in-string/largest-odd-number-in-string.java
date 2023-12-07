class Solution {
    public String largestOddNumber(String num) {
        if(num.length() == 0) return "";

        int lastValue = num.charAt(num.length() - 1) - '0';
        if(lastValue % 2 != 0) return num;

        int index = num.length()-2;
        while(index >= 0)
        {
            int value = num.charAt(index) - '0';
            if(value % 2 != 0)
            {
                return num.substring(0,index + 1);
            }
            index--;
        }
        return "";
    }
}