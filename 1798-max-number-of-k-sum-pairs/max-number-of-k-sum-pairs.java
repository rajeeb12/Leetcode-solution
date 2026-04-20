class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i: nums){
            int num = k - i;
            if(map.containsKey(num)){
                int count = map.get(num);
                if(count == 1){
                    map.remove(num);
                }else{
                    map.put(num, count - 1);
                }
                ans++;
                continue;
            }
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return ans;
    }
}