class Solution {
    public String compressedString(String word) {
        StringBuilder ans = new StringBuilder();

        int count = 0;
        char prevChar = 'a';
        for(int i = 0; i < word.length(); i++){
            if(prevChar == word.charAt(i))
            {
                count++;
            }else{
                if(count != 0) ans.append(count+""+prevChar);
                prevChar = word.charAt(i);
                count = 1;
            }
            if(count == 9){
                ans.append(count+""+prevChar);
                count = 0;
            }
        }
        if(count != 9 && count != 0){
            ans.append(count+""+prevChar);
        }
        return ans.toString();
    }
}