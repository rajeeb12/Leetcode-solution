class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0 , right = n - 1, ans = 0;
        while(left < right)
        {
            int minHeight = Math.min(height[left], height[right]);

            ans = Math.max(ans, (right - left) * minHeight);

            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return ans;
    }
}
