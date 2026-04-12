class Solution {
    public String mergeAlternately(String word1, String word2) {
        if(word1.length() == 0){
            return word2;
        }else if(word2.length() == 0){
            return word1;
        }
        
        StringBuilder ans = new StringBuilder("");
        int index1 = 0, index2 = 0, flag = 1;
        while(index1 < word1.length() && index2 < word2.length()){
            if(flag == 1){
                ans.append(word1.charAt(index1));
                flag = 1 - flag;
                index1++;
            }else{
                ans.append(word2.charAt(index2));
                flag = 1 - flag;
                index2++;
            }
        }   
        while(index1 < word1.length()){
            ans.append(word1.charAt(index1++));
        }
        while(index2 < word2.length()){
            ans.append(word2.charAt(index2++));
        }
        return ans.toString();
    }
}