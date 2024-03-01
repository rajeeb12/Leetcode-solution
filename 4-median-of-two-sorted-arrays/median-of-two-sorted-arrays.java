class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n > m)
        {
            return findMedianSortedArrays(nums2, nums1);
        }
        int low = 0 , high = nums1.length;
        int total = (n + m);
        int half = (n + m + 1) / 2;
        while(low <= high)
        {
            int mid1 = (low + high) >> 1;
            int mid2 = half - mid1;
            int left1 =(mid1 <= 0 ? Integer.MIN_VALUE : nums1[mid1 - 1]);
            int left2 =(mid2 <= 0 ? Integer.MIN_VALUE : nums2[mid2 - 1]);
            int right1 =(mid1 >= n ? Integer.MAX_VALUE : nums1[mid1]);
            int right2 =(mid2 >= m ? Integer.MAX_VALUE : nums2[mid2]);
            
            if(left1 <= right2 && left2 <= right1)
            {
                if(total % 2 == 1) return (double) Math.max(left1, left2);
                int number = Math.max(left1, left2) + Math.min(right1, right2);
                return (number / 2.0);
            }
            else if(left1 > right2)
            {
                high = mid1 -1;
            }else{
                low = mid1 + 1;
            }
        }
        return 0;
    }
}