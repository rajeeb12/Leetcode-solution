class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        int n = nums1.length;
        for(int i = 0; i < nums2.length; i++){
            int minIndex = -1;
            if(i < nums1.length){
                if(nums1[i] <= nums2[i]){
                    minIndex = getIndex(0, i, nums1,nums2, i);
                }
            }else{
                if(nums1[n - 1] <= nums2[i]){
                    minIndex = getIndex(0, n - 1, nums1,nums2, i);
                }
            }
            if(minIndex != -1){
                max = Math.max(max, i - minIndex);
            }
        }
        return max;
    }
    public int getIndex(int left,int right,int nums1[], int nums2[],int i){
        int minIndex = -1;
        while(left <= right){
            int mid= (left + right) >> 1;
            if(nums1[mid] <= nums2[i]){
                right = mid - 1;
                minIndex = mid;
            }else{
                left = mid + 1;
            } 
        }
        return minIndex;
    }
}