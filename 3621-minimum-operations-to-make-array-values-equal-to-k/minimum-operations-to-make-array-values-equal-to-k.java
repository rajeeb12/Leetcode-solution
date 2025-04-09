class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums) set.add(i);
        int count = 0;
        for(int i: set){
            if(i < k) return -1;
            else if(i > k) count++;
        }
        return count;

    }
}