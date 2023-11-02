class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set= new HashSet<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = i + 1; j < n ; j++){
                HashSet<Long> hashSet = new HashSet<>();

                for(int k = j + 1; k < n ; k++){

                    long sum = (nums[i] + nums[j]);
                    sum += nums[k];
                    long rem = target - sum;
                    if(hashSet.contains(rem)){
                        List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k], (int) rem);
                        Collections.sort(temp);
                        set.add(temp);
                    } 
                    // add karo jis kth index element ko in hashset
                    hashSet.add((long) nums[k]);
                }
            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}