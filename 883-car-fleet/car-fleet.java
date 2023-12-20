class Pair{
    int pos;
    int speed;
    public Pair(int _p,int _s)
    {
        this.pos = _p;
        this.speed = _s;
    }
}
class Solution {
    public int carFleet(int target, int[] position, int[] sp) {
        int size = position.length;
        Pair[] arr= new Pair[size];

        for(int i = 0 ; i < size; i++)
        {
            arr[i] = new Pair(position[i], sp[i]);
        }   
        Arrays.sort(arr, (a,b) -> a.pos - b.pos);

        Stack<Double> st = new Stack<>();
        for(int i = size-1; i >= 0 ; i--)
        {
            Pair p = arr[i];
            int pos = p.pos;
            int speed = p.speed;

            double cal = (double) (target - pos) / speed;
            if(!st.isEmpty() && cal <= st.peek())
            {
                continue;
            }else{
                st.add(cal);
            }
        }
        return st.size();
    }
}