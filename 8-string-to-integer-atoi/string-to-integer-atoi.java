class Solution {
    public int myAtoi(String s) {
        if(s.length() == 0) return 0;
        int ans = 0;
        int index = 0;
        int l = s.length(); 
        while(index < l && s.charAt(index) == ' ')
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
            }else if(s.charAt(index) == '+'){
                index++;
            }
        }
        long result = 0;
        for(int i = index; i < s.length() && Character.isDigit(s.charAt(i)); i++)
        {
            int digit = s.charAt(i) -'0';
            if(result > (Integer.MAX_VALUE / 10) || result == (Integer.MAX_VALUE / 10) && digit > 7)
            {
                return (isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE);
            }

            result = result * 10 + digit; 
        }
        if(isNeg) return (int)-result;
        return (int)result;
    }
}