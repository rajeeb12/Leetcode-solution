class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        List<String> ans = new ArrayList<>();
        solve(0, "", digits, ans, map);
        return ans;
    }
    public void solve(int index, String word, String digits, List<String> ans,HashMap<Integer,String> map){
        if(index == digits.length()){
            ans.add(word);
            return;
        }
        int value = digits.charAt(index) - '0';
        String text = map.get(value);
        for(int i = 0; i < text.length(); i++){
            solve(index + 1, word + text.charAt(i), digits, ans, map);
        }
    }
}