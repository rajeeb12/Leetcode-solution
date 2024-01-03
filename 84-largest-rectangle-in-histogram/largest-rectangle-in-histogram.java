class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int n = heights.length;
        int max = 0;
        for(int i = 0 ; i <= n; i++)
        {
            while(!st.isEmpty() && (i == n || heights[st.peek()] >= heights[i]))
            {
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty())
                {
                    width = i;
                }else{
                    width = i - st.peek() - 1;
                }
                max = Math.max(max, width * height);
            }
            st.add(i);
        }
        return max;
    }
}