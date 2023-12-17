class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        String palString = reverse(s); 
        System.out.print(palString);
        return s.equals(palString);
    }
    public String reverse(String s)
    {
        String rev ="";
        for(int i = s.length() - 1; i>=0; i--)
        {
            rev += s.charAt(i);
        }
        return rev;
    }
}