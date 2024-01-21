class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)1e9 + 7;
        int n = arr.length;
        int nle[] = new int[n];
        int ple[] = new int[n];
        
        //Ple
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++)
        {
            while(!st.isEmpty() && arr[st.peek()] >= arr[i])
            {
                st.pop();
            } 
            ple[i] = (st.isEmpty() == true ? -1 : st.peek());

            st.add(i);
        }
        Stack<Integer> st2= new Stack<>();

        for(int i = n - 1; i >= 0 ; i--)
        {
            while(!st2.isEmpty() && arr[st2.peek()] > arr[i])
            {
                st2.pop();
            }
            nle[i] = (st2.isEmpty() ==true ? n : st2.peek());
            st2.add(i);
        }
        long ans = 0;
        for(int i = 0 ; i < n ; i++)
        {
            long l = i - ple[i];
            long r = nle[i] - i;
            ans = (ans + (arr[i] * l * r) % mod) % mod; 
        }
        return (int) ans;
    }
}