class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        for(int i =  n - 2; i >= 0; i--){
            if(nums[i] < nums[i + 1]){
                index = i;
                break;
            }
        }
        if(index == -1) // descending order already
        {
            reverse(0, n - 1,nums);
            return;
        }

        for(int i = n - 1; i >= 0; i--){
            if(nums[i] > nums[index]){
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(index + 1, n - 1, nums);
    }
    public void reverse(int start,int end,int nums[]){
        while(start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}