class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int k = Integer.MIN_VALUE;
        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i >= 0 ; i--){
            if(k > nums[i]) return true;
            while(!st.isEmpty() && st.peek() < nums[i]){
                k = st.pop();
            }
            st.add(nums[i]);
        }
        return false;
    }
}