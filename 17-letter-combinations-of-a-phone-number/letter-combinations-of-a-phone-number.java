class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();

        if(digits.length() == 0) return ans;
        
        String[] arr = {"","","abc","def", "ghi","jkl","mno","pqrs","tuv","wxyz"};

        StringBuilder sb = new StringBuilder("");
        
        solve(0,digits,arr,sb, ans);

        return ans;
    }
    public void solve(int index,String digit, String[] arr, StringBuilder sb,List<String> ans)
    {
        if(index == digit.length())
        {
            ans.add(sb.toString());
            return;
        }
        String str = arr[digit.charAt(index) - '0'];
        for(int i= 0 ; i < str.length(); i++)
        {
            sb.append(str.charAt(i));
            solve(index + 1, digit, arr, sb, ans);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}