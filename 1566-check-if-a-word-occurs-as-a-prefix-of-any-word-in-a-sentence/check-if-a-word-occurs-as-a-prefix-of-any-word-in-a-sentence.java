class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String arr[] = sentence.split(" ");
        int len = searchWord.length();
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            String s = arr[i]; 
            if(s.length() >= len){
                String substr = s.substring(0, len);
                if(substr.equals(searchWord)) return i + 1;
            }     
        }   
        return -1;
    }
}