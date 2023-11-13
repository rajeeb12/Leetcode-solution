class Solution {
    public String mergeAlternately(String word1, String word2) {
        int p1 = 0, p2 = 0;
        boolean turnP1 = true;
        String res = "";
        int n1 = word1.length();
        int n2 = word2.length();

        while(p1 < n1 && p2 < n2){
            if(turnP1){
                res += word1.charAt(p1);
                p1++;
            }else{
                res += word2.charAt(p2);
                p2++;
            }
            turnP1 = !turnP1;
        }
        while(p1 < n1){
            res += word1.charAt(p1);
            p1++;
        }
        while(p2 < n2){
            res += word2.charAt(p2);
            p2++;
        }
        return res;
    }
}