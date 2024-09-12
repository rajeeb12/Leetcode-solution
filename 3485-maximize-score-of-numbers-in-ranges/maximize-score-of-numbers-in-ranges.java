class Solution {
    public int maxPossibleScore(int[] start, int d) {
        int n = start.length;
        long low = 0, high = (int)1e12;
        Arrays.sort(start);
        int ans = 0;
        while(low <= high){
            long mid = (low + high) >> 1;
            if(isValid(start, mid, d)){
                ans = (int) mid;
                low = mid + 1;
            }else{
                high = mid - 1; 
            }
        }
        return ans;
    }
    public boolean isValid(int[] start,long mid, int d){
        
        long x = start[0];
        for(int i = 1; i < start.length; i++){
            long s = start[i];
            long e = start[i] + d;
            
            if((x + mid) >= s && (x + mid) <= e)
            {
                x += mid;
            }else if((x + mid) < s){
                x = start[i];
            }else{
                return false;
            }
        }
        return true;
    }
}