class Solution {
    public String reverseWords(String s) {
        String arr[] = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder("");
        for(int i = arr.length - 1; i >= 0; i--){
            ans.append(arr[i]+ " ");
        }
        return ans.toString().substring(0, ans.length() - 1);
    }
}