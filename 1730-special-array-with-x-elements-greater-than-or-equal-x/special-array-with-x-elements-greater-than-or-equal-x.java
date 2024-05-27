class Solution {
    public int specialArray(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n + 1];
        int csum = 0;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] >= n){
                arr[n]++;
            }
            else{
                arr[nums[i]]++;
            }
        }
        for(int i = n ; i >= 0; i--){
            csum += arr[i];
            if(csum == i) return i;
        }
        return -1;
    }
}