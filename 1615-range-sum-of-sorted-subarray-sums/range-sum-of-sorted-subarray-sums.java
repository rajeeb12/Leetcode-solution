class Pair{
    int num;
    int index;
    public Pair(int _n,int _i){
        this.num = _n;
        this.index = _i;
    }
}
class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int mod = (int)1e9 + 7;
        PriorityQueue<Pair> pq = new PriorityQueue<>( (a, b) -> a.num - b.num);
        for(int i = 0; i < n; i++){
            pq.add(new Pair(nums[i] , i));
        }
        int sum = 0;
        left--;
        right--;
        int i = 0;
        while(!pq.isEmpty())
        {
            Pair temp = pq.poll();
            int number = temp.num;
            int index = temp.index;
            
            if(i >= left && i <= right)
            {
                sum = (sum + number) % mod;
            }
            if(index + 1 < n){
                pq.add(new Pair(number + nums[index + 1] , index + 1));
            }
            i++;
        }
        return sum % mod;
    }
}