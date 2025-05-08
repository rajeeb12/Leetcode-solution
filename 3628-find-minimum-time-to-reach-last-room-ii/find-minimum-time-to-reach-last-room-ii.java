class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int distance[][] = new int[n][m];
        for(int i[]: distance){
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[]{0,0,0,1});
        
        int di[] = {1,-1,0,0};
        int dj[] = {0,0,1,-1};

        while(!pq.isEmpty()){
            int temp[] = pq.poll();
            int prevStep = temp[3];
            if(prevStep == 3){
                prevStep = 1;
            }

            for(int k = 0; k < 4; k++){
                int ni = temp[0] + di[k];
                int nj = temp[1] + dj[k];

                if(ni >= 0 && nj >= 0 && ni < n && nj < m){
                    int curTime = 0;
                    if(temp[2] < moveTime[ni][nj]){
                        curTime = moveTime[ni][nj] + prevStep;
                    }else{
                        curTime = temp[2] + prevStep;
                    }
                    
                    if(curTime < distance[ni][nj]){
                        distance[ni][nj] = curTime;
                        pq.add(new int[]{ni, nj, curTime, prevStep + 1});
                    }
                }
            }
        }
        return distance[n - 1][m - 1];
    }
}