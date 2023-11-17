class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums); // sorting so the larget + smallest , secondLargest + secondsmallest  ... goes on  
        int i = 0 , j =nums.length-1;
        int max = Integer.MIN_VALUE;
        while(i < j ){
            int sum = nums[i] + nums[j];
            max = Math.max(max, sum);
            i++;
            j--;
        }
        return max;
    }
}