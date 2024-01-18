class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0) return false;
        int left = 0 , right = s.length() - 1;

        while(left < right)
        {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(!Character.isLetterOrDigit(leftChar))
            {
                left++;
            }
            else if(!Character.isLetterOrDigit(rightChar))
            {
                right--;
            }else{
                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)){
                    return false;
                }
                right--;
                left++;
            }
        }
        return true;
    }
}