class Solution {
    public int maxArea(int[] height) {
        int left = 0 ,right = height.length - 1, ans = 0;

        while(left < right){
            int width = right - left;
            int min = Math.min(height[left], height[right]);
            ans = Math.max(ans, width * min);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}