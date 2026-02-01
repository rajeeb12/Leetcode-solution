class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) return;
        if(m == 0){
            int index = 0;
            for(int i = 0; i < nums2.length; i++){
                nums1[index++] = nums2[i];
            }
            return;
        }
        // swapping and two pointers
        int i = m - 1, j = n - 1, index = m + n - 1;

        while(i >= 0 && j >= 0){
            if(nums1[i] >= nums2[j]){
                int temp = nums1[i];
                nums1[index] = temp;
                nums1[i] = 0;
                i--;
            }else{
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }
        while(j >= 0){
            nums1[index] = nums2[j--];
            index--;
        }
    }
}