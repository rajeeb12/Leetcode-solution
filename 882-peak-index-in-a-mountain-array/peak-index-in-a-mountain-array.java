class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        if(arr[1] > arr[0] && arr[1] > arr[2]) return 1;
        if(arr[n - 2] > arr[n - 1] && arr[n - 2] > arr[n - 3]) return n - 2;

        int lo = 2 , hi = n - 3;

        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            if(arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
            {
                return mid;
            }
            if(arr[mid] > arr[mid - 1])
            {
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return n;
    }
}