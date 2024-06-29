class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> maxd= new ArrayDeque<>();
        int n = nums.length;
        int ans[] = new int[n - k + 1];

        for(int i = 0; i < k; i++){
            while(!maxd.isEmpty() && nums[i] > maxd.peekLast()) maxd.pollLast();

            maxd.add(nums[i]);
        }
        int index = 0; 
        int i = 0, j;

        ans[index++] = maxd.peek(); 

        for(j = k; j < nums.length; j++){
            while(!maxd.isEmpty() && nums[j] > maxd.peekLast()) maxd.pollLast();
            
            maxd.add(nums[j]);

            if(j - i > k - 1)
            {
                if(nums[i] == maxd.peek()) maxd.poll();
                i++;
            }
            ans[index++] = maxd.peek();
        }
        return ans;
    }
}