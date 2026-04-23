class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        long ans[] = new long[nums.length];
        for(List<Integer> ls: map.values()){
            long totalSum = 0;
            for(int i: ls) totalSum += i;

            long leftSum = 0;

            for(int i = 0; i < ls.size(); i++){
                long rightSum = totalSum - leftSum - ls.get(i);

                long left = (long) (ls.get(i) * 1L * i) - leftSum;
                long right = rightSum - (long) (ls.get(i) * 1L *(ls.size() - i - 1));
                ans[ls.get(i)] = (long) left + right;
                leftSum += ls.get(i);
            }
        }
        return ans;
    }
}