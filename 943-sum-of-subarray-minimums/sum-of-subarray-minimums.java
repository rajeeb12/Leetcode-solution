class Solution {
    public int sumSubarrayMins(int[] arr) {
        int mod = (int)1e9 + 7;
        int n = arr.length;
        long ans = 0;

        int left[] = new int[n]; // storing prev smaller element index 
        int right[] = new int[n]; // storing next smaller element index
        
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        for(int i = 0 ; i < n; i++)
        {
            while(!st1.isEmpty() && arr[st1.peek()] >= arr[i])
            {
                st1.pop();
            }
            left[i] = st1.isEmpty() == true ? -1 : st1.peek();

            st1.add(i);
        }
        for(int i = n-1 ; i >= 0; i--)
        {
            while(!st2.isEmpty() && arr[st2.peek()] > arr[i])
            {
                st2.pop();
            }
            right[i] = st2.isEmpty() == true ? n : st2.peek();

            st2.add(i);
        }

        for(int i = 0 ; i < n ; i++)
        {
            long l = i - left[i];
            long r = right[i] - i;
            long prod = (arr[i] * l * r) % mod;
            ans = (ans + prod) % mod;
        }
        return (int) ans ;
    }
}