class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(nums[i] == key){
                int leftVariable = k;
                set.add(i);
                int leftIndex = i - 1;
                while(leftVariable != 0 && leftIndex >= 0){
                    set.add(leftIndex);
                    leftIndex--;
                    leftVariable--;
                }
                int rightVariable = k;
                int rightIndex = i + 1;
                while(rightVariable != 0 && rightIndex < n){
                    set.add(rightIndex);
                    rightIndex++;
                    rightVariable--;
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i: set){
            ans.add(i);
        }
        Collections.sort(ans);
        return ans;
    }
}