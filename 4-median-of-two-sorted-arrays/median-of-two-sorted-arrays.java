class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int arr[] = new int[n1 + n2];

        int i = 0 , j = 0;
        int index = 0;
        while(i < n1 && j < n2)
        {
            if(nums1[i] < nums2[j])
            {
                arr[index] = nums1[i];
                i++;
            }else{
                arr[index] = nums2[j];
                j++;
            }
            index++;
        }
        while(i < n1)
        {
            arr[index] = nums1[i];
            index++;
            i++;
        }
        while(j < n2)
        {
            arr[index] = nums2[j];
            j++;
            index++;
        }
        if(arr.length % 2 == 0)
        {
            int half = arr.length / 2;
            int sum = arr[half] + arr[half - 1];
            System.out.print(sum);
            return (double) sum / 2;
        }else{
            int half = arr.length / 2;
            return arr[half];
        }
    }
}