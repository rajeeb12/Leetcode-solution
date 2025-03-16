class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int left[] = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < 2 * n; i++){
            if(i >= n && map.containsKey(nums[i % n])){
                left[i % n] = Math.abs(i - map.get(nums[i % n]));
            }
            map.put(nums[i % n], i);
        }
        int right[] = new int[n];

        for(int i = 2 * n - 1; i >= 0; i--){
            if(map.containsKey(nums[i % n])){
                right[i % n] = Math.abs(i - map.get(nums[i % n]));
            }
            map.put(nums[i % n], i);
        }

        List<Integer> ans = new ArrayList<>();

        for(int q: queries){
            if(left[q] >= n && right[q] >= n){
                ans.add(-1);
            }else{
                int min = Math.min(left[q], right[q]);
                ans.add(min);
            }
        }
        return ans;
    }
}