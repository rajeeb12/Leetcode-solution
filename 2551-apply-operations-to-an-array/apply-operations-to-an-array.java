class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        //List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < n - 1; i++){
            if(nums[i] == nums[i + 1]){
                nums[i] *= 2;
                nums[i + 1] = 0; 
            }
        }
        int i = 0;
        while(i < n)
        {
            if(nums[i] == 0){
                int index = i + 1;
                while(index < n && nums[index] == 0) index++;
                if(index < n){
                    int temp = nums[index];
                    nums[index] = nums[i];
                    nums[i] = temp;
                }
            }
            i++;
        }
        return nums;
    }
}