class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<List<Integer>> bucket = new ArrayList<>();
        bucket.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            bucket.add(new ArrayList<>());
        }
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            bucket.get(e.getValue()).add(e.getKey());
        }
        int ans[] = new int[k];
        int index = 0;
        for(int i = nums.length; i >= 0 && k > 0; i--){
            if(bucket.get(i).size() > 0){
                for(int j = 0; j < bucket.get(i).size() && k > 0; j++){
                    ans[index++] = bucket.get(i).get(j);
                    k--;
                }
            }
        }
        return ans;
        
    }
}