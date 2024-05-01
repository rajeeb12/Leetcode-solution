class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        StringBuilder s = new StringBuilder(word.substring(0, index + 1));
        s = s.reverse();
        String ans = s.toString() + word.substring(index + 1, word.length());
        return ans;
    }
}