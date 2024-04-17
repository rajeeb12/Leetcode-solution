class Solution {
    public void nextPermutation(int[] nums) {
        int lindex = -1;
        int n = nums.length;
        for(int i = n - 2; i >= 0; i--)
        {
            if(nums[i] < nums[i + 1]){
                lindex = i;
                break;
            }
        }
        if(lindex == - 1)
        {
            reverse(0, n - 1,nums);
            return;
        }
        
        for(int i = n - 1; i >= 0; i--)
        {
            if(nums[i] > nums[lindex]){
                int temp = nums[lindex];
                nums[lindex] = nums[i];
                nums[i] = temp;
                break; 
            }
        }
        reverse(lindex + 1, n - 1, nums);
    }
    public void reverse(int i,int j,int[] arr){
        while(i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}