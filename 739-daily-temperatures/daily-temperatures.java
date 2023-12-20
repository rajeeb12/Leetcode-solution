class Pair{
    int temp;
    int index;
    public Pair(int _t,int _i)
    {
        this.temp = _t;
        this.index = _i;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        Stack<Pair> st = new Stack();

        st.add(new Pair(temperatures[n-1],n-1));

        for(int i = n - 2; i >= 0 ; i--)
        {
            while(!st.isEmpty())
            {
                if(temperatures[i] >= st.peek().temp)
                {
                    st.pop();
                }
                else{
                    break;
                }
            }
            ans[i] = (st.isEmpty() == true ? 0 : st.peek().index - i);
            st.add(new Pair(temperatures[i], i));
        }
        return ans;
    }
}