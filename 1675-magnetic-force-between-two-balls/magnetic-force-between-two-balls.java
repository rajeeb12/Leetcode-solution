class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1, high = position[n - 1] - position[0];
        int ans = 0;
        while(low <= high){
            int mid = (low + high) >> 1;

            if(check(position, mid, m)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public boolean check(int[] p,int force,int m){
        int count = 1;
        int lastTaken = p[0];

        for(int i = 1; i < p.length; i++){
            if(p[i] - lastTaken >= force){
                count++;
                lastTaken = p[i];
            }
        }
        return (count >= m);
    }
}