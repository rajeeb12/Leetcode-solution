class Pair{
    int ticket;
    int index;
    public Pair(int _t,int _i){
        this.ticket = _t;
        this.index = _i;
    }
}
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Pair> q = new LinkedList<>();
        int n = tickets.length;
        for(int i = 0; i < n; i++){
            q.add(new Pair(tickets[i] , i));
        }
        int ans = 0;
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            int t = p.ticket;
            int i = p.index;

            ans++;
            if(t - 1 == 0 && i == k)
            {
                break;
            }else if(t - 1 == 0){
                continue;
            }
            q.add(new Pair(t - 1, i));
        }
        return ans;
    }
}