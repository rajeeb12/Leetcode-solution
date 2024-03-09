class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int n = nums1.length;
        int m = nums2.length; 
        while(p1 < n && p2 < m)
        {
            if(nums1[p1] == nums2[p2])
            {
                return nums1[p1];
            }else if(nums1[p1] < nums2[p2])
            {
                p1++;
            }else{
                p2++;
            }
        }
        return -1;
    }
}