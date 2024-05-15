class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq = new PriorityQueue<>((a,b) -> Long.compare(b,a));
        long sum  = 0;
        for(int i = 0; i < target.length; i++){
            long num = (long) target[i];
            sum += num;
            pq.add(num);
        }

        while(true)
        {
            long top = pq.poll();
            sum -= top;
            if(top == 1 || sum == 1) return true;
            if(sum <= 0 || sum >= top || top % sum == 0) return false;
            
            top %= sum;
            sum += top;
            pq.add(top);
        }
    }
}