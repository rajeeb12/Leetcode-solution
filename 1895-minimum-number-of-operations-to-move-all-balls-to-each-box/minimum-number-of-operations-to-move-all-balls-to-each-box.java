class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int ans[] = new int[n];
        for(int i = 0 , count = 0, ops = 0; i < n; i++){
            ans[i] += ops;
            count += (boxes.charAt(i) == '1' ? 1 : 0);
            ops += count;
        }
        for(int i = n - 1 , count = 0, ops = 0; i >= 0; i--){
            ans[i] += ops;
            count += (boxes.charAt(i) == '1' ? 1 : 0);
            ops += count;
        }
        return ans;

    }
}