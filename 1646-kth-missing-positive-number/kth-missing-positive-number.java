class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;

        while(lo <= hi)
        {
            int mid = (lo + hi) >> 1;
            int missingNo = arr[mid] - mid - 1;
            if(missingNo < k)
            {
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return hi + k + 1;
    }
}