class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i: asteroids){
            while(!st.isEmpty() && st.peek() > 0 && i < 0){
                int diff = st.peek() - Math.abs(i);
                if(diff < 0){
                    st.pop();
                }else if(diff > 0){
                    i = 0;
                }else{
                    i = 0;
                    st.pop();
                }
            }
            if(i > 0 || i < 0) st.add(i);
        }

        int index = st.size() - 1;
        int ans[] = new int[st.size()];
        while(!st.isEmpty()){
            ans[index--] = st.pop();
        }
        return ans;
    }
}