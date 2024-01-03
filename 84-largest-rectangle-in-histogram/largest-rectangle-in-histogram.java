class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int nse[] = nextSmallestElement(heights, new Stack<>()); 
        int pse[] = prevSmallestElement(heights, new Stack<>());
        int max = 0;
        for(int i= 0 ; i < n ; i++)
        {
            max = Math.max(max, ((nse[i] - 1) - (pse[i] + 1) + 1) * heights[i]);
        }
        return max;

    }
    public int[] nextSmallestElement(int[] h,Stack<Integer> st)
    {
        int n = h.length;
        int nse[]= new int[n];
        st.add(n-1);
        nse[n-1] = n;

        for(int i = n - 2; i >= 0; i--)
        {
            while(!st.isEmpty() && h[st.peek()] >= h[i])
            {
                st.pop();
            }

            if(st.isEmpty())
            {
                nse[i] = n;
            }else{
                nse[i] = st.peek();
            }
            st.add(i);
        }
        return nse;
    }
    public int[] prevSmallestElement(int[] h,Stack<Integer> st)
    {
        int n = h.length;
        int pse[]= new int[n];
        st.add(0);
        pse[0] = -1;

        for(int i = 0; i < n; i++)
        {
            while(!st.isEmpty() && h[st.peek()] >= h[i])
            {
                st.pop();
            }

            if(st.isEmpty())
            {
                pse[i] = -1;
            }else{
                pse[i] = st.peek();
            }
            st.add(i);
        }
        return pse;
    }
}