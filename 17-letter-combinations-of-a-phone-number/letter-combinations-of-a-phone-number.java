class Solution {
    String arr[] = {"","", "abc","def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> ans  = new ArrayList<>();
        
        if(digits.length() == 0){
            return ans;
        }

        solve(0,"",ans,digits);
        return ans;
    }
    public void solve(int index,String str,List<String> ans,String digits)
    {
        if(str.length() == digits.length())
        {
            ans.add(str);
            return;
        }

        String number = arr[digits.charAt(index) - '0'];
        for(int j = 0; j < number.length() ; j++)
        {
            solve(index + 1, str + number.charAt(j), ans, digits);
        }
    }
}