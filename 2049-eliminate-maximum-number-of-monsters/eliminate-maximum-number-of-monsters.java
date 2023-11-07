class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int count = 1 ;
        ArrayList<Integer> time = new ArrayList<>();
        int n = dist.length;  
        for(int i = 0; i < n; i++){
            int calTime = (int) Math.ceil((double) dist[i] / speed[i]);
            time.add(calTime);
        }
        Collections.sort(time);

        int timePass = 1;
        for(int i = 1; i<n; i++){
            if(time.get(i) - timePass <= 0) return count;
            count++;
            timePass++;
        }
        return count;
    }
}