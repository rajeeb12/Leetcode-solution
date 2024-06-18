class Solution {
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int n = s.length;
        int prefix[] = new int[1];
        int curSum = s[n - 1];
        prefix[0] = s[n - 1];
        for(int i = n - 2; i >= 0; i--){

            prefix[0] += s[i]; 
            
            if(prefix[0] < 0) break;

            curSum += prefix[0];
        }
        return ( curSum < 0 ? 0 : curSum );
    }
}