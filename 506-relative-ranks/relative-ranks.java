class Pair{
    int val;
    int index;
    public Pair(int _v,int _i)
    {
        this.val = _v;
        this.index = _i;
    }
}
class Solution {
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> Integer.compare(y.val , x.val));

        for(int i = 0; i < score.length; i++)
        {
            pq.add(new Pair(score[i] , i));
        } 
        int n = score.length;
        String ans[] = new String[n];
        int count = 1;
        while(!pq.isEmpty())
        {
            Pair p = pq.poll();
            int index = p.index;
            if(count <= 3){
                if(count == 1){
                    ans[index] = "Gold Medal";
                }else if(count == 2){
                    ans[index] = "Silver Medal";
                }else{
                    ans[index] = "Bronze Medal";
                }
                count++;
            }
            else{
                ans[index] = Integer.toString(count);
                count++;
            }
        }
        return ans;
    }
}