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
        int dummy[] = new int[m + n];
        // two pointers
        int size = Math.min(m, n);
        int i = 0, j = 0, index = 0;

        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                dummy[index] = nums1[i];
                i++;
            }else{
                dummy[index] = nums2[j];
                j++;
            }
            System.out.print(dummy[index]);
            index++;
        }
        while(i < m){
            dummy[index++] = nums1[i];
            i++;
        }
        while(j < n){
            dummy[index++] = nums2[j];
            j++;
        }
        for(int k = 0; k < nums1.length; k++){
            nums1[k] = dummy[k];
        }

        // dummy - 1, 2, 2, 3, 5, 6
        // i = 0 -> 1 -> 2 -> 3
        // j = 0 -> 1 -> 2 -> 3
    }
}