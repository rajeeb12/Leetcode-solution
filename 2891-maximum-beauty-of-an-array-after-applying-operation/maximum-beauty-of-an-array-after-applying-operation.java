class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Deque<int[]> q = new ArrayDeque<>();
        int n = nums.length;
        int arr[][] = new int[n][2];

        
        for(int i = 0; i < n; i++){
            arr[i][0] = nums[i] - k;
            arr[i][1] = nums[i] + k;
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        q.add(new int[]{arr[0][0], arr[0][1]});
        int ans = 1;

        for(int i = 1; i < n; i++)
        {
            while(!q.isEmpty() && arr[i][0] > q.peekFirst()[1]){
                q.pollFirst();
            }
            q.add(new int[]{arr[i][0], arr[i][1]});

            ans = Math.max(ans, q.size());
        }
        return ans;
    }
}