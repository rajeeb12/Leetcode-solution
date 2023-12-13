class Solution {
    public int maxArea(int[] height) {
        int left = 0 , right = height.length - 1;
        int maxWater = 0;
        while(right > left)
        {
            if(height[left] < height[right])
            {
                maxWater = Math.max(maxWater, height[left] * (right-left));
                left++;
            }else{
                maxWater = Math.max(maxWater, height[right] * (right-left));
                right--;
            }
        }   
        return maxWater;
    }
}