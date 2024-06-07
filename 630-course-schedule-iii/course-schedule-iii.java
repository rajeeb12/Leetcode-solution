class Pair{
    int a;
    int b;
    public Pair(int _a,int _b){
        this.a = _a;
        this.b = _b;
    }
}
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a); 
        int total = 0;
        for(int i[]: courses){
            total += i[0];
            pq.add(i[0]);
            if(total > i[1]) total -= pq.poll();
        }
        return pq.size();
    }
}