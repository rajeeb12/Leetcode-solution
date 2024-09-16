class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean map[] = new boolean[24 * 60];

        for(String s: timePoints){
            String arr[] = s.split(":");
            int h = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            if(map[h * 60 + m]) return 0;
            map[h * 60 + m] = true;
        }
        int first = (int)1e9;
        int last = 0, prev = 0, min = (int) 1e9;
        for(int i = 0; i < 24 * 60; i++){
            if(map[i])
            {
                if(first != (int)1e9){
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        min = Math.min(min, ((24 * 60) - (last  - first)));
        return min;
    }
}