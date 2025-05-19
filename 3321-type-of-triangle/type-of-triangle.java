class Solution {
    public String triangleType(int[] nums) {
        if(nums[0] + nums[1] <= nums[2] || nums[0] + nums[2] <= nums[1] || nums[1] + nums[2] <= nums[0]) return "none";
        HashSet<Integer> set = new HashSet<>();

        for(int i: nums) set.add(i);

        if(set.size() == 1) return "equilateral";
        else if(set.size() == 2) return "isosceles";
        return "scalene";
    }
}