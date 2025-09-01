class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lmax = 0, rmax = 0, i = 0, j = n - 1, total = 0;

        while(i < j){
            if(height[i] <= height[j]){
                if(lmax > height[i]){
                    total += lmax - height[i];
                }else{
                    lmax = height[i];
                }
                i++;
            }else{
                if(rmax > height[j]){
                    total += rmax - height[j];
                }else{
                    rmax = height[j];
                }
                j--;
            }
        }
        return total;
    }
}