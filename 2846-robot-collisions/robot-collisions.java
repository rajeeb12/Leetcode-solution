class Pair{
    int index;
    int position;
    public Pair(int _i,int _p){
        this.index = _i;
        this.position = _p;
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] health, String directions) {
        Stack<Pair> st = new Stack<>();
        int n = positions.length;
        Pair arr[] = new Pair[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = new Pair(i, positions[i]);
        }

        Arrays.sort(arr, new Comparator<Pair>()
        {
            public int compare(Pair a, Pair b){
                return Integer.compare(a.position, b.position);
            }
        });

        for(int i = 0; i < n; i++){
            if(directions.charAt(arr[i].index) == 'L')
            {
                int index = arr[i].index;
                while(!st.isEmpty() && health[index] > 0)
                {
                    if(health[index] == health[st.peek().index])
                    {
                        health[index] = -1;
                        health[st.peek().index] = -1;
                        st.pop();
                    }else if(health[index] < health[st.peek().index]){
                        health[index] = -1;
                        health[st.peek().index]--;
                    }else{
                        health[st.peek().index] = -1;
                        st.pop();
                        health[index]--;
                    }
                }
            }else{
                st.add(arr[i]);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            if(health[i] > 0){
                ans.add(health[i]);
            }
        }
        return ans;
    }
}