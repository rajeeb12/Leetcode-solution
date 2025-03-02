class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int max = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i[]: nums1){
            max = Math.max(max, i[0]);
            set.add(i[0]);
        }
        for(int i[]: nums2){
            max = Math.max(max, i[0]);
            set.add(i[0]);
        }
        int temp[] = new int[max + 1];

        for(int i[]: nums1){
            temp[i[0]] += i[1];
        }
        for(int i[]: nums2){
            temp[i[0]] += i[1];
        }
        int ans[][] = new int[set.size()][2];

        int index = 0;
        for(int i = 0; i <= max; i++){
            if(temp[i] == 0) continue;
            ans[index][0] = i;
            ans[index][1] = temp[i];
            index++; 
        }
        return ans;
    }
}