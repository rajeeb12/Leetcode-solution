class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int max = 1;
        for(int i = 0; i < n; i++){
            if(i + 1 < n && (nums[i] & nums[i + 1]) == 0){
                int j = i + 2;
                int temp = nums[i] | nums[i + 1];
                boolean flag = true;
                while(flag && j < n){
                    for(int k = 0; k < 31; k++){
                        int bit1 = (temp >> k) & 1;
                        int bit2 =  (nums[j] >> k) & 1;
                        if(bit1 == 1 && bit2 == 1){
                            flag = false;
                            break;
                        }
                    }
                    if(flag && j < n){
                        temp |= nums[j];
                        j++;
                    }
                }
                max = Math.max(max, j - i);
            }
        }
        return max;
    }
}