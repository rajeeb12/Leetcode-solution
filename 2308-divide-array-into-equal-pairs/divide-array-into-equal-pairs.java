class Solution {
    public boolean divideArray(int[] nums) {
        int n = nums.length;
        int totalPair = n / 2;
        int count[] = new int[501];

        for(int i: nums){
            count[i]++;
        }

        for(int i = 1; i < 500; i++){
            if(count[i] % 2 == 1) return false;
        }
        return true;
    }
}