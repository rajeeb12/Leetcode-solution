class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0) return 0;
        int index = 0;
        while(index < s.length() && s.charAt(index) == ' ')
        {
            index++;
        }
        boolean isNeg = false;
        if(index < s.length())
        {
            if(s.charAt(index) == '-')
            {
                isNeg = true;
                index++;
            }
            else if(s.charAt(index) == '+'){
                index++;
            }
        }
        
        long sum = 0;
        for(int i = index; i < s.length() && Character.isDigit(s.charAt(i)) ; i++)
        {
            int digit = s.charAt(i) - '0';
            if((sum == (Integer.MAX_VALUE/10) && digit > 7) || sum > (Integer.MAX_VALUE / 10 ))
            {
                return (isNeg ? Integer.MIN_VALUE: Integer.MAX_VALUE);
            }
            sum = sum * 10 + digit;
        }
        if(isNeg) return (int)-sum;
        return (int)sum;
    }
}