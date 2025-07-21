class Solution {
    public String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(ans.length() < 2){
                ans.append(s.charAt(i));
            }else{
                int len = ans.length();
                if(ans.charAt(len - 1) != s.charAt(i) || ans.charAt(len - 2) != s.charAt(i)) ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}