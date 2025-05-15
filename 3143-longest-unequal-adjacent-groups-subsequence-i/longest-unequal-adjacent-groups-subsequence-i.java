class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int last = -1;
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(groups[i] != last){
                ans.add(words[i]);
                last = groups[i];
            }
        }
        return ans;
    }
}