class Solution {
    public String mergeAlternately(String word1, String word2) {
        String result = "";
        int min = Math.min( word1.length(), word2.length());
        int index = 0;
        for(int i = 0; i < min; i++)
        {
            result += word1.charAt(i);
            result += word2.charAt(i);
            index++;
        }
        while(index < word1.length()) result += word1.charAt(index++);
        while(index < word2.length()) result += word2.charAt(index++);

        return result;
    }
}