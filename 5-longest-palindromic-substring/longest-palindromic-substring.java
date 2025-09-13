class Solution {
    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[1001][1001];

        int n = s.length(), start = -1, end = -1, max = 0;

        for(int len = 1; len <= n; len++){
            for(int i = 0; i + len - 1 < n; i++){
                int j = i + len - 1;

                if(s.charAt(i) == s.charAt(j)){
                    if(len <= 2 || dp[i + 1][j - 1]){
                        dp[i][j] = true;
                        if(j - i + 1 > max){
                            start = i;
                            end = j;
                            max = j - i + 1;
                        }
                    }
                }
            }
        }
        if(start != -1) return s.substring(start, end + 1);
        return "";
    }
}