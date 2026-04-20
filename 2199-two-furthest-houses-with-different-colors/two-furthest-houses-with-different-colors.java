class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        if(colors[0] != colors[n - 1]) return n - 1;

        return Math.max(leftMove(0, n - 1, colors), rightMove(0, n - 1, colors));
    }
    public int leftMove(int l,int r,int nums[]){
        while(l < r){
            if(nums[l] != nums[r]) return Math.abs(l - r);
            l++;
        }
        return -1;
    }
    public int rightMove(int l,int r,int nums[]){
        while(l < r){
            if(nums[l] != nums[r]) return Math.abs(l - r);
            r--;
        }
        return -1;
    }
}