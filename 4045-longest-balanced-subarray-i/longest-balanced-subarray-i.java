class Solution {
    public int longestBalanced(int[] nums) {
        int longest = 0;
        for(int i = 0; i < nums.length; i++){
            
            if(longest > nums.length - i) break;

            HashSet<Integer> even = new HashSet<>();
            HashSet<Integer> odd = new HashSet<>();
            for(int j = i; j < nums.length; j++){
                if(nums[j] % 2 == 0) even.add(nums[j]);
                else odd.add(nums[j]);

                if(even.size() == odd.size()){
                    longest = Math.max(longest, j - i + 1);
                }
            }
        }
        return longest;
    }
}