class Solution {
    public int scoreOfString(String s) {
        int sum = 0;
        int n = s.length();
        for(int i = 0; i < n - 1; i++)
        {
            int diff = (int)Math.abs(s.charAt(i) - s.charAt(i + 1));
            sum += diff;
        }
        return sum;
    }
}