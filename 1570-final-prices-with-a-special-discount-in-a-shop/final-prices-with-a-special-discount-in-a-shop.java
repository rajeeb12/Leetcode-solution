class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int ns[] = new int[n];
        Stack<Integer> st = new Stack<>();
        ns[n - 1] = 0;
        st.add(prices[n - 1]);

        for(int i = n - 2; i >= 0; i--){
            while(!st.isEmpty() && prices[i] < st.peek()) st.pop();
            ns[i] = (st.isEmpty() ? 0 : st.peek());
            st.add(prices[i]);
        }
        int ans[] = new int[n];
        for(int i = 0 ; i < n; i++){
            ans[i] = prices[i] - ns[i];
        }
        return ans;
    }
}