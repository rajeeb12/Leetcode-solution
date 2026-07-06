class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int lmax = 0, rmax = 0, ans = 0;

        while(i < j){
            if(height[i] <= height[j]){
                if(lmax > height[i]){
                    ans += lmax - height[i];
                }else{
                    lmax = height[i];
                }
                i++;
            }else{
                if(rmax > height[j]){
                    ans += rmax - height[j];
                }else{
                    rmax = height[j];
                }
                j--;
            }
        }
        return ans;
    }
}