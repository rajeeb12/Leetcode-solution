class Solution {
    public int minOperations(String s) {
        int start_with_zero = 0;
        int start_with_one = 0;
        int n = s.length();
        for(int i = 0 ; i < n; i++)
        {
            if(i % 2 == 0)
            {
                if(s.charAt(i) == '1')
                {
                    start_with_zero++;
                }else{
                    start_with_one++;
                }
            }else{
                if(s.charAt(i) == '1')
                {
                    start_with_one++;
                }else{
                    start_with_zero++;
                }
            }
        }
        return Math.min(start_with_zero, start_with_one);
    }
}