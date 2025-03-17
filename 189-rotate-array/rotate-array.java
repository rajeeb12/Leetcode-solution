class Solution {
    public void rotate(int[] nums, int k) {
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        k = k % n;
        for(int i = n - k; i < n; i++){
            temp.add(nums[i]);
        } 
        for(int i = n - k - 1; i >= 0; i--){
            nums[i + k] = nums[i];
        }
        for(int i = 0; i < temp.size(); i++){
            nums[i] = temp.get(i);
        }
    }
}