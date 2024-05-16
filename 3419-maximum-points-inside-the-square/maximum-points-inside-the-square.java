class Solution {
    public int maxPointsInsideSquare(int[][] points, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++)
        {
            char c = s.charAt(i);
            int maxCor = Math.max(Math.abs(points[i][0]) , Math.abs(points[i][1]));

            if(!map.containsKey(c)){
                map.put(c, maxCor);
            }else if(maxCor < map.get(c)){
                min = Math.min(map.get(c) ,min);
                map.put(c, maxCor);
            }else{
                min = Math.min(min, maxCor);
            }
        }
        int count = 0;
        for(int i : map.values()){
            if(i < min){
                count++;
            }
        }
        return count;
    }
}