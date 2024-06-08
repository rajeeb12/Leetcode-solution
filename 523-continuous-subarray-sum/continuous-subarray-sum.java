class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        map.put(0,-1);
        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum % k)){
                if(i - map.get(sum % k) > 1){
                    return true;
                }
            }
            else map.put(sum % k , i);
        }
        return false;
    }
}