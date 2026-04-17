class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for(int i: nums){
            if(i < first){
                first = i;
            }else if(i < second && first != i){
                second = i;
            }else if(i > first && i > second){
                return true;
            }
        } 
        return false;
    }
}