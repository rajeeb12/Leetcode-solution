class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int ts = times[targetFriend][0];
        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> availableSeats = new PriorityQueue<>();

        for(int i = 0; i < times.length; i++) availableSeats.add(i);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        for(int time[]: times)
        {
            while(!pq.isEmpty() && time[0] >= pq.peek()[0]){
                availableSeats.add(pq.poll()[1]);
            }
            if(time[0] == ts) break;
            int seat = availableSeats.poll();
            pq.add(new int[]{time[1], seat});
        } 
        return availableSeats.poll();
    }
}