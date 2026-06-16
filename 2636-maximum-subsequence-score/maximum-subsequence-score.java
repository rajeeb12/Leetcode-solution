class Pair{
    int a;
    int b;
    public Pair(int _a,int _b){
        this.a = _a;
        this.b = _b;
    }
}
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        List<Pair> arr = new ArrayList<>();

        for(int i = 0; i < n; i++){
            Pair p = new Pair(nums1[i], nums2[i]);
            arr.add(p);
        }
        Collections.sort(arr, (p, q)-> q.b - p.b);
        PriorityQueue<Pair> pq = new PriorityQueue<>((p,q) -> p.a - q.a);

        long ans = 0, sum = 0;
        for(int i = 0; i < n; i++){
            Pair temp = arr.get(i);
            sum = sum + (long) temp.a;
            pq.add(temp);
            if(pq.size() > k){
                Pair temp2 = pq.poll();
                sum -= temp2.a;
            }
            if(pq.size() == k){
                ans = (long) Math.max(ans, (long) sum * temp.b);
            }
        }
        return ans;
    }
}