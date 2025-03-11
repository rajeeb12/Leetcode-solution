class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < n ; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = n - 1;

            while(j < k)
            {   
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum == 0)
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j - 1]) j++;
                    
                    while(j < k && nums[k] == nums[k + 1]) k--;

                    ans.add(temp);
                }else if(sum < 0){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return ans;
    }
}