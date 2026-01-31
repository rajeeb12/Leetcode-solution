class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int dummy[] = new int[m + n];
        int index = 0;
        for(int i = 0; i < m; i++){
            dummy[index++] = nums1[i];
        }
        for(int i = 0; i < n; i++){
            dummy[index++] = nums2[i];
        }
        Arrays.sort(dummy); // o(nlogn)
        for(int i = 0; i < nums1.length; i++){ // O(m + n);
            nums1[i] = dummy[i];
        }
        // O(nlogn) + O(n + m) 
    }
}