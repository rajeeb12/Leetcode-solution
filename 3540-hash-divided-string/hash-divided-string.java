class Solution {
    public String stringHash(String s, int k) {
        String ans = "";
        for(int i = 0; i < s.length(); i += k){
            String substr = s.substring(i, i + k);
            ans += processedString(substr); 
        }
        return ans;
    }
    public char processedString(String s){
        int sum = 0;
        for(char c: s.toCharArray())
        {
            sum += c -'a';
        }
        sum = sum % 26;
        return ((char)(sum +'a'));
    }
}