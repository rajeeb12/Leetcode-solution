class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(int i = 0; i < words.length; i++){
            if(words[i].length() >= pref.length()){ 
                String substr = words[i].substring(0, pref.length());
                if(substr.equals(pref)) count++;
            }
        }
        return count;
    }
}