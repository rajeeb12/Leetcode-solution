class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix[0].length;
        int[] arr= new int[m];
        int maxArea= 0;

        for(char row[]: matrix)
        {
            for(int j=0; j<m; j++)
            {
                if(row[j] == '1')
                {
                    arr[j] += 1;
                }
                else{
                    arr[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, getMaxArea(arr));
        }
        return maxArea;
    }
    public int getMaxArea(int[] arr)
    {
        int nse[]= nextSmallest(arr, new Stack<>());
        int pse[]= prevSmallest(arr, new Stack<>());

        int maxArea = 0;
        for(int i=0; i<arr.length; i++)
        {
            int cal = ((nse[i] - pse[i]) - 1) * arr[i];
            maxArea = Math.max(maxArea, Math.max(cal, arr[i])); 
        }
        return maxArea;
    }
    public int[] nextSmallest(int[] arr, Stack<Integer> st)
    {
        int nse[]= new int[arr.length]; 
        for(int i = arr.length-1 ; i >= 0; i--){
            while(st.size() > 0 && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }
            nse[i]= (st.size() == 0 ? arr.length : st.peek());
            st.add(i);
        }
        return nse;
    }
    public int[] prevSmallest(int[] arr, Stack<Integer> st)
    {
        int pse[]= new int[arr.length]; 
        for(int i = 0 ; i < arr.length; i++){
            while(st.size() > 0 && arr[st.peek()] >= arr[i])
            {
                st.pop();
            }
            pse[i]= (st.size() == 0 ? -1 : st.peek());
            st.add(i);
        }
        return pse;
    }

}