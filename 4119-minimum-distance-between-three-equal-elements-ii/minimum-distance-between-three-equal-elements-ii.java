class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        int minDistance = (int)1e9;
        for(Map.Entry<Integer, List<Integer>> e: map.entrySet()){
            if(e.getValue().size() >= 3){
                List<Integer> temp = e.getValue();
                int index = 0;
                while(index + 2 < temp.size()){
                    int distance = (2 * Math.max(temp.get(index), Math.max(temp.get(index + 1), temp.get(index + 2)))) -(2 * Math.min(temp.get(index), Math.min(temp.get(index + 1), temp.get(index + 2))));
                    minDistance = Math.min(minDistance, distance);
                    index++;
                }
            }
        }
        return (minDistance == (int)1e9 ? -1 : minDistance);
    }
}