class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int f : freq) {
            if (f > 0) pq.offer(f);
        }

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int cnt = pq.poll() - 1;

                if (cnt != 0) {
                    q.offer(new Pair(cnt, time + n));
                }
            }

            if (!q.isEmpty() && q.peek().getValue() == time) {
                pq.offer(q.poll().getKey());
            }
        }

        return time;
    }
}
