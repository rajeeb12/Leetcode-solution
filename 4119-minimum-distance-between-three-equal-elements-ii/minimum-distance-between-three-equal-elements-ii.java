class Solution {
    public int minimumDistance(int[] nums) {
        int map[][] = new int[nums.length + 1][2];
        int minDistance = (int)1e9;
        
        for(int i = 0; i < nums.length; i++){
            if(map[nums[i]][0] != 0){
                minDistance = Math.min(minDistance,2 * (i - map[nums[i]][0] + 1));
            }
            map[nums[i]][0] = map[nums[i]][1];
            map[nums[i]][1] = i + 1;
        }
        return (minDistance == (int)1e9 ? -1 : minDistance);
    }
}