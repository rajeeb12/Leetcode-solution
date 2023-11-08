class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int h = Math.abs(sy - fy);
        int v = Math.abs(sx - fx);   
        if( h == 0 && v == 00 && t == 1) return false;
        int minTime = Math.max(h,v);
        if(t < minTime) return false;
        return true;
    }
}