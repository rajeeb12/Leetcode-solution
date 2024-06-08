class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];
            sum %= k;
            if(map.containsKey(sum)){
                if(i - map.get(sum) > 1){
                    return true;
                }
            }
            else map.put(sum , i);
        }
        return false;
    }
}