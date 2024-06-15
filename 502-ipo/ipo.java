
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        ArrayList<int[]> list= new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(new int[]{capital[i], profits[i]});
        }
        Collections.sort(list, (a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int count = 1;
        int index = 0;
        
        while(k-- > 0){
            while(index < n && list.get(index)[0] <= w){
                pq.add(list.get(index)[1]);
                index++;
            }
            if(pq.isEmpty()) break;

            w += pq.poll();
        }
        return w;
    }
}