class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int end = -1;
        int start = -1, j = n - 1;
        if(n == 0) return 0;
        boolean found = false;
        while(s.charAt(j) == ' ')
        {
            j--;
        } 
        if(s.charAt(j) != ' ') found = true;
        if(found){
            end = j;
            while(j >=0 && s.charAt(j) != ' ')
            {
                j--;
            }
            start = j + 1;
            return end - start + 1;
        }
        return 0;
    }
}