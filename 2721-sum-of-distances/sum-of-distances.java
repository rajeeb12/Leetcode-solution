class Solution {
    public long[] distance(int[] nums) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        long ans[] = new long[n];
        for(Map.Entry<Integer, List<Integer>> e: map.entrySet()){
            int number = e.getKey();
            List<Integer> indexes = e.getValue();
            long total = 0;
            for(int i: indexes) total += i;

            long prefix = 0;
            for(int i = 0; i < indexes.size(); i++){
                int index = indexes.get(i);
                long postSum = total - prefix - index;

                long left = (long) (index * 1L * (i)) - prefix;
                long right = (long) postSum - (index * 1L * (indexes.size() - i - 1));
                long cal = (long) left + right;
                ans[index] = cal;
                prefix += indexes.get(i);
            }
        }
        return ans;
    }
}