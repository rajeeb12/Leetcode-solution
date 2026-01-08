class Solution {
    public int repeatedNTimes(int[] nums) {
        int occurence = nums.length / 2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue() == occurence) return e.getKey();
        }
        return -1;
    }
}