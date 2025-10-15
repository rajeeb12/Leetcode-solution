class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> map =  new HashMap<>();

        for(int i: nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue() >= 2) return true;
        }
        return false;
    }
}