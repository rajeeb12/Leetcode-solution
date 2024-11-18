class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long csum = 0;
        Deque<long[]> q = new ArrayDeque<>();
        int ans = (int)1e9;
        for(int i = 0; i < n; i++){
            csum += nums[i];
            if(csum >= k){
                ans = Math.min(ans, i + 1);
            }
            while(!q.isEmpty() && csum - q.peekFirst()[0] >= k){
                long[] temp = q.pollFirst();
                ans = Math.min(ans, i - (int) temp[1]);
            }
            while(!q.isEmpty() && q.peekLast()[0] > csum){
                q.pollLast();
            }
            
            q.add(new long[]{csum, (long) i});
        }
        return (ans == (int)1e9 ? -1 : ans);
    }
}