class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        Arrays.sort(potions);
        int ans[] = new int[n];

        for(int i = 0; i < n; i++){
            int spell = spells[i];

            int left = 0 , right = m - 1;
            int index = -1;
            while(left <= right){
                int mid = (left + right) >> 1;
                if((long) spell * potions[mid] >= success){
                    index = mid;
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            if(index != -1){
                ans[i] = m - index;
            }
        }
        return ans;
    }
}