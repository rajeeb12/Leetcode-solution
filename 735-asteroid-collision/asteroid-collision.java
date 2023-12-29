class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int elm: asteroids){
            while(!st.isEmpty() && st.peek() > 0 && elm < 0)
            {
                int diff= st.peek() - Math.abs(elm);
                if(diff < 0)
                {
                    st.pop();
                }else if(diff > 0) //ignore by making elm = 0 only adding -ve || +ve 
                {
                    elm = 0;
                }else{
                    elm = 0;
                    st.pop(); 
                }
            }
            if(elm < 0 || elm > 0)
            {
                st.add(elm);
            }
        }
        int ans[]= new int[st.size()];

        for(int i = st.size() - 1; i >= 0; i--)
        {
            ans[i] = st.pop();
        }
        return ans;
    }
}