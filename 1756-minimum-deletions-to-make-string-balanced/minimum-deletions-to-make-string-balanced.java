class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int map[][] = new int[2][n], countB = 0, countA = 0;

        for(int i = 0; i < n; i++){
            map[0][i] = countB;
            map[1][n - i - 1] = countA;
            countB += (s.charAt(i) == 'b' ? 1 : 0);
            countA += (s.charAt(n - i - 1) == 'a' ? 1 : 0);
        }
        
        int result = (int)1e9;
        for(int i = 0; i < n; i++){
            result =  Math.min(map[0][i] + map[1][i], result);
        }
        return result;

    }
}