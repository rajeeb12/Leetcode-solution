class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int ans = n + 1;
        for(int i = 0; i < n; i++){
            if(words[i].equals(target)){
                int x = Math.abs(i - startIndex);
                ans = Math.min(ans, Math.min(x, n - x));
            }
        }
        return (ans == n  + 1 ? -1 : ans);
    }
}