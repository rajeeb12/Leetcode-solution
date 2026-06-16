class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int left = 0, right = costs.length - 1, hired = 0;
        long ans = 0;
        while(hired < k){

            while(pq1.size() < candidates && left <= right){
                pq1.add(costs[left++]);
            }
            while(pq2.size() < candidates && left <= right){
                pq2.add(costs[right--]);
            }

            int cost1 = (pq1.isEmpty() ? (int)1e9 : pq1.peek());
            int cost2 = (pq2.isEmpty() ? (int)1e9 : pq2.peek());
            if(cost1 == cost2){
                ans = (long) ans + cost1;
                pq1.poll();
            }else if(cost1 < cost2){
                ans = (long) ans + cost1;
                pq1.poll();
            }else{
                ans = (long) ans + cost2;
                pq2.poll();
            }
            hired++;
        }
        return ans;
    }
}