class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int elem = 0;

        for(int num: nums){
            if(count == 0){
                elem = num;
            }
            if(elem == num){
                count++;
            }else{
                count--;
            }
        }
        return elem;
    }
}