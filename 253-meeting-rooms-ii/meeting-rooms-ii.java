class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        pq.add(new int[]{start, end});
        int max = 0;
        
        for(int i = 1; i < intervals.length; i++)
        {
            while(!pq.isEmpty() && intervals[i][0] >= pq.peek()[1]) pq.poll();

            pq.add(new int[]{intervals[i][0], intervals[i][1]});
            max = Math.max(max, pq.size());
        }
        return Math.max(max, pq.size());
    }
}