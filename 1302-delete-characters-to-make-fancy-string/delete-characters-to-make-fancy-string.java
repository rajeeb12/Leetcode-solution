class Solution {
    public String makeFancyString(String s) {
        
        StringBuilder ans = new StringBuilder(s.charAt(0));
        char prev = s.charAt(0);
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(prev == s.charAt(i)){
                count++;
            }else{
                prev = s.charAt(i);
                count = 1;
            }
            if(count == 3){
                count = 2;
                continue;
            }
            ans.append(s.charAt(i));
        }
        return ans.toString();
    }
}