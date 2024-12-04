class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        if(str2.length() > str1.length()) return false;

        int j = 0;
        for(int i = 0; i < str1.length() && j < str2.length(); i++){
            char a = str1.charAt(i) , b = str2.charAt(j);

            if(a == b || a + 1 == b || a - 25 == b){
                j++;
            }
        }
        return (j == str2.length());
    }
}